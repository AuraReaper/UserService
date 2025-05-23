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
    private Long id;

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
}
