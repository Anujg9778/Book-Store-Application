package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Job;
import com.example.greencommute.respository.JobRepository;
import com.example.greencommute.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl  implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }

    @Override
    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findJobById(int theJobId) {
        return jobRepository.findById(theJobId);
    }

    @Override
    public void deleteJob(int theJobId) {
        jobRepository.deleteById(theJobId);
    }

    @Override
    public Job saveJob(Job theJob) {
        return jobRepository.save(theJob);
    }

    @Override
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.getJobsByLocation(location);
    }

    @Override
    public List<Job> getJobsBySkills(String skill) {
        return jobRepository.getJobsBySkill(skill);
    }

}
