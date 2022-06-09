package com.example.greencommute.service;

import com.example.greencommute.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService{

    List<Job> findAllJobs();

    Optional<Job> findJobById(int theJobId);

    void deleteJob(int theJobId);

    Job saveJob(Job theJob);

    List<Job> getJobsByLocation(String location);

    List<Job> getJobsBySkills(String skill);

}
