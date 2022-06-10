package com.example.greencommute.respository;


import com.example.greencommute.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepository  extends JpaRepository<Job,Integer> {

    @Query("select J from Job J where jobLocation=:location")
    List<Job> getJobsByLocation(@Param("location") String location);

    @Query(value="select * from jobs,skills,jobs_skills where jobs.job_id=jobs_skills.job_id and skills.skill_id = jobs_skills.skill_id and skills.skill_name=:skill",
            nativeQuery=true)
    List<Job> getJobsBySkill(@Param("skill") String skill);
}

