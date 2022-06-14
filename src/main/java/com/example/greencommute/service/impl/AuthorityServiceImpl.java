package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;
import com.example.greencommute.respository.AuthorityRepository;
import com.example.greencommute.service.AuthorityService;
import com.example.greencommute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    private final UserService userService;

    public AuthorityServiceImpl(UserService userService,AuthorityRepository authorityRepository){
        this.authorityRepository=authorityRepository;
        this.userService=userService;
    }

    @Override
    public Authorities addUser(User user) {

        Authorities authority=new Authorities();
        authority.setUserName(user.getUserName());
        authority.setAuthority(user.getRole());
        User user2= userService.saveUser(user);
        authority.setUser(user2);
        return authorityRepository.save(authority);
    }

    @Override
    public User findUserByUserName(String userName) {

        Optional<Authorities> authority= authorityRepository.findById(userName);

        User user;
        log.info("user "+authority.isPresent());

        if(authority.isPresent()){
            user=authority.get().getUser();
            log.info(authority.get().getUserName());

            log.info(authority.get().getAuthority());
            log.info(" user: "+user);

            user.setRole(authority.get().getAuthority());
            return user;
        }

        user=new User();
        user.setUserName("not found");
        return user;
    }

}
