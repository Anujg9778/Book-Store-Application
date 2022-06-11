package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.Skill;
import com.example.greencommute.respository.JobRepository;
import com.example.greencommute.service.JobService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
class JobServiceImplTest {

    private JobService jobService;

    @Mock
    private JobRepository jobRepository;

    @BeforeEach
    void initUseCase(){
        jobService = new JobServiceImpl(jobRepository);
    }


    @Test
    void findAllJobsTest() {

        Job job1=new Job(0,"System Engineer","Hyderabad",null);
        Job job2=new Job(0,"C shark developer","pune",null);

        List<Job> jobsList = new ArrayList<>();
        jobsList.add(job1);
        jobsList.add(job2);
        Mockito.when(jobRepository.findAll()).thenReturn(jobsList);
        Assertions.assertEquals(jobsList, jobService.findAllJobs());
        Mockito.verify(jobRepository).findAll();
    }

    @Test
    void findJobByIdTest() {
        Job job = new Job(1,"Software Engineer","Hyderabad",null);
        Optional<Job> jobsOptional = Optional.of(job);
        Mockito.when(jobRepository.findById(1)).thenReturn(jobsOptional);
        Assertions.assertEquals(jobsOptional, jobService.findJobById(1));
        Mockito.verify(jobRepository).findById(1);
    }

    @Test
    void deleteJobTest() {

        Job job = new Job(1,"Software Engineer","Hyderabad",null);

        doNothing().when(jobRepository).deleteById(1);
        jobService.deleteJob(1);
        Mockito.verify(jobRepository).deleteById(1);

    }

    @Test
    void saveJobTest() {
        Job job = new Job(1,"Software Engineer","Hyderabad",null);

        Mockito.when(jobRepository.save(job)).thenReturn(job);
        Assertions.assertEquals(job, jobService.saveJob(job));
        Mockito.verify(jobRepository).save(job);
    }

    @Test
    void getJobsByLocationTest() {
        List<Job> jobsList = new ArrayList<>();
        Job job = new Job(1,"Software Engineer","Hyderabad",null);
        jobsList.add(job);
        Mockito.when(jobRepository.getJobsByLocation("Hyderabad")).thenReturn(jobsList);
        Assertions.assertEquals(jobsList, jobService.getJobsByLocation("Hyderabad"));
        Mockito.verify(jobRepository).getJobsByLocation("Hyderabad");
    }

    @Test
    void getJobsBySkillsTest() {

        List<Job> jobsList = new ArrayList<>();

        Skill skill=new Skill(1,"spring");
        List<Skill> skills=new ArrayList<>();
        skills.add(skill);

        Job job = new Job(1,"Software Engineer","Hyderabad",skills);
        jobsList.add(job);

        Mockito.when(jobRepository.getJobsBySkill("spring")).thenReturn(jobsList);
        Assertions.assertEquals(jobsList, jobService.getJobsBySkills("spring"));
        Mockito.verify(jobRepository).getJobsBySkill("spring");
    }
}