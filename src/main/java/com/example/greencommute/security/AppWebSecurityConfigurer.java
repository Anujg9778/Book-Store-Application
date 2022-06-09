

package com.example.greencommute.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //add our users for in memory authentication

        User.UserBuilder users= User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("mary").password("sec123").roles("USER"))
                .withUser(users.username("carl").password("carl123").roles("ADMIN"))
                .withUser(users.username("mehar").password("mehar123").roles("ADMIN"));
    }

}
