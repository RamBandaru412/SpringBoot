package com.learn.springboot.learn_jdbc.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.springboot.learn_jdbc.course.Course;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate SpringJdbcTemplate;
	private static String INSERT_QUERY = 
			"""
			insert into course (id,name,author)
			values(?,?,?);
			""";
	public static String DELETE_QUERY = 
			"""
			delete from course where id = ?;
			""";
	private static String SELECT_QUERY = 
			"""
			select * from course where id = ?;
			""";
	
	public void deleteById(long id) {
		SpringJdbcTemplate.update(DELETE_QUERY,id);
	}
	public Course selectById(long id) {
		return SpringJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
		
	}
	public void insert(Course course) {
		SpringJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());		
	}
	
}
