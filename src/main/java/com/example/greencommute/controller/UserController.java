package com.example.greencommute.controller;


import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;
import com.example.greencommute.exception.JobNotFoundException;
import com.example.greencommute.mapper.JobMapper;
import com.example.greencommute.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/user")
@Slf4j
@RestController
public class UserController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobMapper jobMapper;

    @GetMapping("/jobs")
    public List<JobDTO> findAllJobs(){
        return jobService.findAllJobs()
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/{jobId}")
    public Optional<Job> findJobById(@PathVariable int jobId){

        Optional<Job> theJob=jobService.findJobById(jobId);
        if(!theJob.isPresent()){
            throw new JobNotFoundException("Given Id doesnot exist");
        }

        return jobService.findJobById(jobId);
    }

    @GetMapping("/jobs/location")
    public List<JobDTO> getJobsByLocation(@RequestParam("location") String location){
        return jobService.getJobsByLocation(location)
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/skills")
    public List<JobDTO> getJobsBySkills(@RequestParam("skill") String skill){
        return jobService.getJobsBySkills(skill)
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }
}
