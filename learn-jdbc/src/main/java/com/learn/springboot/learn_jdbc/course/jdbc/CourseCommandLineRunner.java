package com.learn.springboot.learn_jdbc.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.learn.springboot.learn_jdbc.course.Course;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Spring","RAM"));
		repository.insert(new Course(2,"JAVA","RAM"));
		repository.insert(new Course(3,"SQL","RAM"));
		repository.deleteById(1);
		System.out.println(repository.selectById(2));
	}
	

}
