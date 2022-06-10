package com.example.greencommute.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
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
    private int enabled;
}
