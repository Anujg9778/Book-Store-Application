package com.example.greencommute.mapper;

import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class JobMapperTest {

    JobMapper jobMapper;

    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
        jobMapper=new JobMapper(modelMapper);
    }

    @Test
    void toJobsDtoTest() {
        Job job = new Job(1,"software engineer","hyderabad",null);
        JobDTO jobDto = new JobDTO(1,"software engineer","hyderabad",null);

        Mockito.when(modelMapper.map(job,JobDTO.class)).thenReturn(jobDto);
        Assertions.assertEquals(jobDto,jobMapper.convertToJobDTO(job));
        Mockito.verify(modelMapper).map(job,JobDTO.class);
    }

    @Test
    void toJobTest() {
        Job job = new Job(1,"software engineer","hyderabad",null);
        JobDTO jobDto = new JobDTO(1,"software engineer","hyderabad",null);

        Mockito.when(modelMapper.map(jobDto,Job.class)).thenReturn(job);
        Assertions.assertEquals(job,jobMapper.convertToJob(jobDto));
        Mockito.verify(modelMapper).map(jobDto,Job.class);
    }

    @Test
    void toJobsDtoListTest() {

        Job job = new Job(1,"software engineer","hyderabad",null);
        JobDTO jobDto = new JobDTO(1,"software engineer","hyderabad",null);
        List<Job> jobsList = new ArrayList<>();
        List<JobDTO> jobsDtoList = new ArrayList<>();
        jobsList.add(job);
        jobsDtoList.add(jobDto);

        Mockito.when(modelMapper.map(job,JobDTO.class)).thenReturn(jobDto);
        Assertions.assertEquals(jobsDtoList,jobMapper.toJobDtoList(jobsList));
        Mockito.verify(modelMapper).map(job,JobDTO.class);
    }
}
