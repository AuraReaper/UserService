package com.yash.UserService.consumer;

import com.yash.UserService.deserializer.UserInfoEvent;
import com.yash.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceConsumer {

    @Autowired
    private UserService userService;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoEvent eventData) {
        try {
            userService.createOrUpdateUser(eventData);
        }catch (Exception e){
            log.error("AuthServiceConsumer: Error in consuming event");
        }
    }
}
