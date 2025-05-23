package com.yash.UserService.service;

import com.yash.UserService.entities.UserInfo;
import com.yash.UserService.entities.UserInfoDto;
import com.yash.UserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto) {

        UserInfo transformToUserInfo = UserInfo.builder()
                .userid(userInfoDto.userId())
                .firstName(userInfoDto.firstName())
                .lastName(userInfoDto.lastName())
                .phoneNumber(userInfoDto.phoneNumber())
                .email(userInfoDto.email())
                .profilePic(userInfoDto.profilePic())
                .username(userInfoDto.username())
                .build();

        UnaryOperator<UserInfo> updatingUser = user -> userRepository.save(transformToUserInfo);

        Supplier<UserInfo> createUser = () -> userRepository.save(transformToUserInfo);

        UserInfo userInfo = userRepository.findByUserid(userInfoDto.userId())
                .map(updatingUser)
                .orElseGet(createUser);

        return new UserInfoDto(
                userInfo.getUserid(),
                userInfo.getUsername(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception {
        Optional<UserInfo> userInfoDtoOpt = userRepository.findByUserid(userInfoDto.userId());
        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();

        return new UserInfoDto(
                userInfo.getUserid(),
                userInfo.getUsername(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }
}
