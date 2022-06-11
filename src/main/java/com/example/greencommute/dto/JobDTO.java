package com.example.greencommute.dto;


import com.example.greencommute.entity.Skill;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    private int jobId;
    private String jobName;
    private String jobLocation;
    private List<Skill> skills;

}
