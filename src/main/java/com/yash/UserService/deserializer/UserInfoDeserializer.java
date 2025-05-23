package com.yash.UserService.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class UserInfoDeserializer  implements Deserializer<UserInfoEvent> {


    @Override
    public UserInfoEvent deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoEvent user = null;
        try {
            user = objectMapper.readValue(bytes, UserInfoEvent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
