package com.example.greencommute.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JobDTOTest {

    JobDTO jobDTO=new JobDTO(1,"software engineer","Hyderabad",null);

    @Test
    void jobsDtoEntityTest(){

        Assertions.assertEquals(1, jobDTO.getJobId());
        Assertions.assertEquals("software engineer", jobDTO.getJobName());
        Assertions.assertEquals("Hyderabad",jobDTO.getJobLocation());
        Assertions.assertNull(jobDTO.getSkills());

        JobDTO jobDTO1=new JobDTO();
        jobDTO1.setJobId(2);
        jobDTO1.setJobName("Analyst");
        jobDTO1.setJobLocation("mumbai");
        jobDTO1.setSkills(null);

        Assertions.assertEquals(2, jobDTO1.getJobId());
        Assertions.assertEquals("Analyst", jobDTO1.getJobName());
        Assertions.assertEquals("mumbai",jobDTO1.getJobLocation());
        Assertions.assertNull(jobDTO1.getSkills());

    }


}