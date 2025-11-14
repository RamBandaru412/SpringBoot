package com.ram.learn_maven;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@RequestMapping("/courses")
	public List<Course> retriveCourse() {
		return Arrays.asList(
				new Course(1,"AWS","RAM"),
				new Course(2,"JAVA","RAM")
				);
	}

}
