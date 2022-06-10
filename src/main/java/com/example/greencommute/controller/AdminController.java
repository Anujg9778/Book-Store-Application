package com.example.greencommute.controller;


import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.Skill;
import com.example.greencommute.exception.JobNotFoundException;
import com.example.greencommute.mapper.JobMapper;
import com.example.greencommute.service.JobService;
import com.example.greencommute.service.SkillService;
import com.example.greencommute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/admin")
@Slf4j
@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillService skillService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobMapper jobMapper;

    @PostMapping("/jobs")
    public JobDTO saveJob(@RequestBody JobDTO theJobDTO){

        Job theJob=jobMapper.convertToJob(theJobDTO);

        List<Skill> skills=theJob.getSkills();

        if(skills!=null){
            for (Skill skill:skills) {
                skillService.saveSkill(skill);
            }
        }
        return jobMapper.convertToJobDTO(jobService.saveJob(theJob));
    }

    @PutMapping("/jobs")
    public JobDTO updateJob(@RequestBody JobDTO theJobDTO){

        Job theJob=jobMapper.convertToJob(theJobDTO);

        checkJobId(theJob.getJobId());

        return jobMapper.convertToJobDTO(jobService.saveJob(theJob));
    }

    @DeleteMapping("/jobs/{jobId}")
    public String deleteJobById(@PathVariable int jobId){

        checkJobId(jobId);

        jobService.deleteJob(jobId);
        return " job with jobId :"+jobId+" deleted.";

    }


    @GetMapping("/jobs")
    public List<JobDTO> findAllJobs(){
        return jobService.findAllJobs()
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/{jobId}")
    public Optional<Job> findJobById(@PathVariable int jobId){

        checkJobId(jobId);

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

    private void checkJobId(int jobId){
        Optional<Job> theJob=jobService.findJobById(jobId);
        if(!theJob.isPresent()){
            throw new JobNotFoundException("Given Id does not exist");
        }
    }
}
