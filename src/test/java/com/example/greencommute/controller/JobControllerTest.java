package com.example.greencommute.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;
import com.example.greencommute.entity.Skill;
import com.example.greencommute.mapper.JobMapper;
import com.example.greencommute.service.JobService;

import com.example.greencommute.service.SkillService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class JobControllerTest {

    @Mock
    JobService jobService;

    @Mock
    SkillService skillService;

    @InjectMocks
    JobController jobController;

    @Mock
    JobMapper jobMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(jobController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getJobByIdTest() throws Exception {
        Job job = new Job(1, "Software Engineer", "Hyderabad", null);
        JobDTO jobDto = jobMapper.convertToJobDTO(job);
        Optional<Job> jobsOptional = Optional.of(job);

        when(jobService.findJobById(1)).thenReturn(jobsOptional);
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/jobs/1").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(jobDto))).
                andDo(MockMvcResultHandlers.print());
        verify(jobService).findJobById(1);
        verify(jobService, times(1)).findJobById(1);
    }

    @Test
    void getJobsTest() throws Exception{
        Job job = new Job(1,"Software Engineer","Hyderabad",null);
        Skill skill1 = new Skill(1,"c");
        Skill skill2=new Skill(2,"hibernate");
        List<Skill> skillsList = new ArrayList<>();
        skillsList.add(skill1);
        skillsList.add(skill2);

        job.setSkills(skillsList);
        JobDTO jobDto = jobMapper.convertToJobDTO(job);
        Optional<Job> jobsOptional = Optional.of(job);
        List<Job> jobsList = new ArrayList<>();
        jobsList.add(job);

        List<JobDTO> jobsDtoList = jobMapper.toJobDtoList(jobsList);
        when(jobService.findAllJobs()).thenReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/jobs").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(jobsDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(jobService).findAllJobs();
        verify(jobService,times(1)).findAllJobs();

        when(jobService.getJobsByLocation("Hyderabad")).thenReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/jobs/location?location=Hyderabad").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(jobsDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(jobService).getJobsByLocation("Hyderabad");
        verify(jobService,times(1)).getJobsByLocation("Hyderabad");

        when(jobService.getJobsBySkills("hibernate")).thenReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/jobs/skills?skill=hibernate").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(jobsDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(jobService).getJobsBySkills("hibernate");
        verify(jobService,times(1)).getJobsBySkills("hibernate");

    }

}