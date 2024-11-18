package com.Emmanuel.scripture_sharing.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private Integer id;
    private String firstname;
    private String midname;
    private String lastname;
    private String profilePicture;
    private String bio;
    private UserResponse user;
}
