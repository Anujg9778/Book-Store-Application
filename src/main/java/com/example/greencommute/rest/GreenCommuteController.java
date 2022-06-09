package com.example.greencommute.rest;

import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.Skill;
import com.example.greencommute.entity.User;
import com.example.greencommute.service.JobService;
import com.example.greencommute.service.SkillService;
import com.example.greencommute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class GreenCommuteController {

    Logger myLogger=Logger.getLogger(GreenCommuteController.class.getName());
    @Autowired
    private UserService userService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private JobService jobService;

    @GetMapping("/users")
    public List<User> findUsers(){
        return userService.findAll();
    }

    @GetMapping("/jobs")
    public List<Job> findAllJobs(){

        myLogger.info(" got all the jobs");
        return jobService.findAllJobs();
    }

    @GetMapping("/jobs/{jobId}")
    public Optional<Job> findJobById(@PathVariable int jobId){
        return jobService.findJobById(jobId);
    }



    @PostMapping("/jobs")
    public Job saveJob(@RequestBody Job theJob){

        List<Skill> skills=theJob.getSkills();

        if(skills!=null){
            for(Skill skill:skills)
                skillService.saveSkill(skill);
        }
        myLogger.info(" job id :"+theJob.getJobId()+"job name :"+theJob.getJobName()+"the skills"+theJob.getSkills());

        return jobService.saveJob(theJob);
    }

    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job theJob){
        return jobService.saveJob(theJob);
    }

    @DeleteMapping("/jobs/{jobId}")
    public void deleteJobById(@PathVariable int jobId){
        jobService.deleteJob(jobId);
    }

    @GetMapping("/jobs/location={location}")
    public List<Job> getJobsByLocation(@PathVariable("location") String location){

        return jobService.getJobsByLocation(location);
    }


}