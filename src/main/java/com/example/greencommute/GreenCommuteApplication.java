package com.example.greencommute;

import com.example.greencommute.mapper.JobMapper;
import com.example.greencommute.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreenCommuteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenCommuteApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	@Bean
	public JobMapper jobMapper(){
		return new JobMapper(modelMapper());
	}

	@Bean
	public UserMapper userMapper(){
		return new UserMapper(modelMapper());
	}
}
