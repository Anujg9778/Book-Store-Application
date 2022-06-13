package com.example.greencommute.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
public class Authority {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "authority")
    private String authority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username")
    private User user;

    public Authority(String userName, String authority) {
        this.userName = userName;
        this.authority = authority;
    }
}
