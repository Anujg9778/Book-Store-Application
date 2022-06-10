package com.example.greencommute.dto;


import com.example.greencommute.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    private int jobId;
    private String jobName;
    private String jobLocation;
    private List<Skill> skills;

}
