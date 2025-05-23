package com.yash.UserService.deserializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yash.UserService.entities.UserInfo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoEvent
{

    @NonNull
    private String userId;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private Long phoneNumber;

    @NonNull
    private String email;

    private String profilePic;

    public UserInfo transformToUserInfo() {
        return UserInfo.builder()
                .firstName(firstName)
                .lastName(lastName)
                .userId(userId)
                .email(email)
                .profilePic(profilePic)
                .phoneNumber(phoneNumber).build();
    }

}
