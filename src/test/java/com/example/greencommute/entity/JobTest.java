package com.example.greencommute.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobTest {

    Job job = new Job(1,"Software Engineer","Hyderabad",null);

    @Test
    void jobEntityTest(){

        assertEquals(1,job.getJobId());
        assertEquals("Software Engineer",job.getJobName());
        assertEquals("Hyderabad",job.getJobLocation());
        assertNull(job.getSkills());

        Job job1=new Job();
        job1.setJobId(2);
        job1.setJobName("Software Engineer");
        job1.setJobLocation("Mumbai");
        job1.setSkills(null);

        assertEquals(2,job1.getJobId());
        assertEquals("Software Engineer",job1.getJobName());
        assertEquals("Mumbai",job1.getJobLocation());
        assertNull(job1.getSkills());
    }

}