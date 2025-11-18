package com.ram.learn_maven;

public class Course {
	private long id;
	private String course;
	private String author;
	
	public long getId() {
		return id;
	}
	public String getCourse() {
		return course;
	}
	public String getAuthor() {
		return author;
	}
	
	public Course(long id, String course, String author) {
		super();
		this.id = id;
		this.course = course;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", author=" + author + "]";
	}
	

}
