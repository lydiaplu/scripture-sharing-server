package com.Emmanuel.scripture_sharing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    private String midname;

    @Column(nullable = false)
    private String lastname;

    private String profilePicture;

    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserProfile() {

    }
}
