package com.yash.UserService.service;

import com.yash.UserService.deserializer.UserInfoEvent;
import com.yash.UserService.entities.UserInfo;
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

    public UserInfoEvent createOrUpdateUser(UserInfoEvent userInfoEvent) {

        UnaryOperator<UserInfo> updatingUser = user -> userRepository.save(userInfoEvent.transformToUserInfo());

        Supplier<UserInfo> createUser = () -> userRepository.save(userInfoEvent.transformToUserInfo());

        UserInfo userInfo = userRepository.findByUserId(userInfoEvent.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

        return new UserInfoEvent(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

    public UserInfoEvent getUser(String email) throws Exception {
        Optional<UserInfo> userInfoDtoOpt = userRepository.findByEmail(email);
        if(userInfoDtoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();

        return new UserInfoEvent(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }
}
