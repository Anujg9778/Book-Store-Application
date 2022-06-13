package com.example.greencommute.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private int enabled=1;

    @Transient
    private String role;

    public User(String userName, String password, int enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }
}
