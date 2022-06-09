package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Job;
import com.example.greencommute.respository.JobRepository;
import com.example.greencommute.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl  implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Job> findJobById(int theJobId) {
        return jobRepository.findById(theJobId);
    }

    @Override
    @Transactional
    public void deleteJob(int theJobId) {
        jobRepository.deleteById(theJobId);
    }

    @Override
    @Transactional
    public Job saveJob(Job theJob) {
        return jobRepository.save(theJob);
    }

    @Override
    public List<Job> getJobsByLocation(String location) {

        Query query=entityManager.createQuery("from Job where jobLocation=:location");

        query.setParameter("location",location);

        return query.getResultList();

    }

}
