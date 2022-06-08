package com.example.greencommute.rest;

import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.User;
import com.example.greencommute.service.JobService;
import com.example.greencommute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreenCommuteController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @GetMapping("/users")
    public List<User> findUsers(){
        return userService.findAll();
    }

    @GetMapping("/jobs")
    public List<Job> findAllJobs(){
        return jobService.findAllJobs();
    }

    @PostMapping("/jobs")
    public Job saveJob(Job theJob){
        jobService.saveJob(theJob);
        return null;
    }
}