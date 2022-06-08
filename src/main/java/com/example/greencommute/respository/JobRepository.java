package com.example.greencommute.respository;


import com.example.greencommute.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository  extends JpaRepository<Job,Integer> {
}
