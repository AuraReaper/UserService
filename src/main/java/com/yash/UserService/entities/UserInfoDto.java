package com.yash.UserService.entities;


public record UserInfoDto(
        String userId,
        String username,
        String firstName,
        String lastName,
        Long phoneNumber,
        String email,
        String profilePic

)  {

}
