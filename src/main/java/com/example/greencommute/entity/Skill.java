package com.example.greencommute.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skill_id")
    private int skillId;

    @Column(name="skill_name")
    private String skillName;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="jobs_skills",
            joinColumns = @JoinColumn(name="skill_id"),
            inverseJoinColumns = @JoinColumn(name="job_id")

    )
    private List<Job> jobs;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="user_skills",
            joinColumns = @JoinColumn(name="skill_id"),
            inverseJoinColumns = @JoinColumn(name="username")

    )
    private List<User> users;

}
