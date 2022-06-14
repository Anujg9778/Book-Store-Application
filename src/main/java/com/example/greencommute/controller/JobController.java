package com.example.greencommute.controller;

import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.Skill;
import com.example.greencommute.exception.JobNotFoundException;
import com.example.greencommute.mapper.JobMapper;
import com.example.greencommute.service.JobService;
import com.example.greencommute.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/jobs")
@Slf4j
@RestController
public class JobController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobMapper jobMapper;

    public void checkJobId(int jobId) throws JobNotFoundException{
        Optional<Job> theJob=jobService.findJobById(jobId);
        if(!theJob.isPresent()){
            throw new JobNotFoundException("Given Id does not exist");
        }
    }

    @PostMapping("/add-job")
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

    @PutMapping("/")
    public JobDTO updateJob(@RequestBody JobDTO theJobDTO){

        Job theJob=jobMapper.convertToJob(theJobDTO);

        checkJobId(theJob.getJobId());

        return jobMapper.convertToJobDTO(jobService.saveJob(theJob));
    }

    @DeleteMapping("/{jobId}")
    public String deleteJobById(@PathVariable int jobId){

        checkJobId(jobId);

        jobService.deleteJob(jobId);
        return " job with jobId :"+jobId+" deleted.";
    }

    @GetMapping("/")
    public List<JobDTO> findAllJobs(){

        return jobService.findAllJobs()
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{jobId}")
    public JobDTO findJobById(@PathVariable int jobId){

        Optional<Job> theJob=jobService.findJobById(jobId);
        if(!theJob.isPresent()){
            throw new JobNotFoundException("Given Id does not exist");
        }
        return jobMapper.convertToJobDTO(theJob.get());
    }

    @GetMapping("/location")
    public List<JobDTO> getJobsByLocation(@RequestParam("location") String location){

        return jobService.getJobsByLocation(location)
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/skills")
    public List<JobDTO> getJobsBySkills(@RequestParam("skill") String skill){

        return jobService.getJobsBySkills(skill)
                .stream()
                .map(jobMapper::convertToJobDTO)
                .collect(Collectors.toList());
    }

}
