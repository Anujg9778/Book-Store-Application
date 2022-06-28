package com.example.bookstoreapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        final String ADMIN="ADMIN";

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT).hasRole(ADMIN)
                .antMatchers(HttpMethod.DELETE).hasRole(ADMIN)
                .antMatchers("/books/add_book").hasRole(ADMIN)
                .and()
                .httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest().permitAll();
    }

}
