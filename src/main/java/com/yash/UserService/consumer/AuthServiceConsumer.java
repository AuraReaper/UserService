package com.yash.UserService.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.UserService.entities.UserInfoDto;
import com.yash.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceConsumer {

    private UserService userService;

    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData) {
        try {
            userService.createOrUpdateUser(eventData);
        }catch (Exception e){
            e.printStackTrace();
            log.error("AuthServiceConsumer: Error in consuming event");
        }
    }
}
