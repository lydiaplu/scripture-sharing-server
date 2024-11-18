package com.Emmanuel.scripture_sharing.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileRequest {
    private String firstname;
    private String midname;
    private String lastname;
    private String profilePicture;
    private String bio;
    private Integer user;
}
