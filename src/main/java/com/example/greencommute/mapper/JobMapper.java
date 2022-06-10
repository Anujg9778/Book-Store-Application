package com.example.greencommute.mapper;

import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



public class JobMapper {

    @Autowired
    ModelMapper modelMapper;

    public JobDTO convertToJobDTO(Job theJob){
        return modelMapper.map(theJob,JobDTO.class);
    }

    public Job convertToJob(JobDTO jobDTO){
        return modelMapper.map(jobDTO,Job.class);
    }
}
