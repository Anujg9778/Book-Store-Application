package com.example.greencommute.controller;


import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.Skill;
import com.example.greencommute.entity.User;
import com.example.greencommute.exception.JobNotFoundException;
import com.example.greencommute.service.JobService;
import com.example.greencommute.service.SkillService;
import com.example.greencommute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@Slf4j
@RestController
public class AdminConstructor {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillService skillService;

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
            throw new JobNotFoundException("Given Id does not exist");
        }
        return theJob;
    }


    @PostMapping("/jobs")
    public Job saveJob(@RequestBody Job theJob){

        List<Skill> skills=theJob.getSkills();

        if(skills!=null){
            for (Skill skill:skills) {
                skillService.saveSkill(skill);
            }
        }
        log.info(" job id :"+theJob.getJobId()+"job name :"+theJob.getJobName()+"the skills"+theJob.getSkills());

        return jobService.saveJob(theJob);
    }

    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job theJob){
        return jobService.saveJob(theJob);
    }

    @DeleteMapping("/jobs/{jobId}")
    public void deleteJobById(@PathVariable int jobId){

        Optional<Job> theJob=jobService.findJobById(jobId);

        if(theJob==null){
            throw new JobNotFoundException("Given Id does not exist");
        }
        jobService.deleteJob(jobId);
    }

    @GetMapping("/jobs/location")
    public List<Job> getJobsByLocation(@RequestParam("location") String location){
        return jobService.getJobsByLocation(location);
    }

    @GetMapping("/jobs/skills")
    public List<Job> getJobsBySkills(@RequestParam("skill") String skill){
        return jobService.getJobsBySkills(skill);
    }

    @GetMapping("/users")
    public List<User> findUsers(){
        return userService.findAll();
    }

}
