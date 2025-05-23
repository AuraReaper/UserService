package com.yash.UserService.repository;

import com.yash.UserService.entities.UserInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface  UserRepository extends CrudRepository<UserInfo, String> {

     Optional<UserInfo> findByUserid(String userid);
}
