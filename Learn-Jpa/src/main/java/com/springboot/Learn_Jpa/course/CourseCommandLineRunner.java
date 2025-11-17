package com.springboot.Learn_Jpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.Learn_Jpa.course.jpa.CourseJpaRepository;
@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn SpringBoot","RAM"));
		repository.insert(new Course(2,"Learn Rest-Api","RAM"));
		repository.insert(new Course(3,"Learn AWS","RAM"));

		repository.deleteById(2);
		
		System.out.println(repository.findById(1));
		System.out.println(repository.findById(3));
		
		

	}

}
