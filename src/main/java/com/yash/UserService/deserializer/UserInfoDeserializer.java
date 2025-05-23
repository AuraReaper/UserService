package com.yash.UserService.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.UserService.entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;

public class UserInfoDeserializer  implements Deserializer {


    @Override
    public UserInfoDto deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null;
        try {
            user = objectMapper.readValue(bytes, UserInfoDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
