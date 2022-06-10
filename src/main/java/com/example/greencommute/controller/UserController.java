package com.example.greencommute.controller;


import com.example.greencommute.entity.Job;
import com.example.greencommute.exception.JobNotFoundException;
import com.example.greencommute.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@Slf4j
@RestController
public class UserController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> findAllJobs(){

        return jobService.findAllJobs();
    }

    @GetMapping("/jobs/{jobId}")
    public Optional<Job> findJobById(@PathVariable int jobId){

        Optional<Job> theJob=jobService.findJobById(jobId);
        if(theJob==null){
            throw new JobNotFoundException("Given Id doesnot exist");
        }

        return jobService.findJobById(jobId);
    }

    @GetMapping("/jobs/location")
    public List<Job> getJobsByLocation(@RequestParam("location") String location){
        return jobService.getJobsByLocation(location);
    }

    @GetMapping("/jobs/skills")
    public List<Job> getJobsBySkills(@RequestParam("skill") String skill){
        return jobService.getJobsBySkills(skill);
    }

}
