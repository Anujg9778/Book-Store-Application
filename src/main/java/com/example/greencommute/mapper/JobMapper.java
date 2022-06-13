package com.example.greencommute.mapper;

import com.example.greencommute.dto.JobDTO;
import com.example.greencommute.entity.Job;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class JobMapper {
    ModelMapper modelMapper;

    public JobMapper(ModelMapper mapper){
        this.modelMapper=mapper;
    }

    public JobDTO convertToJobDTO(Job theJob){
        return modelMapper.map(theJob,JobDTO.class);
    }

    public Job convertToJob(JobDTO jobDTO){
        return modelMapper.map(jobDTO,Job.class);
    }

    public List<JobDTO> toJobDtoList(List<Job> jobsList){
        return jobsList.stream().map(this::convertToJobDTO).collect(Collectors.toList());
    }

}

