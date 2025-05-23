package com.yash.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userid;

    private String username;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String profilePic;
}
