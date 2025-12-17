package com.example.FirstHtmlPage.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
	private static int todocount = 0;
	private static List<Todo> todos = new ArrayList<>();
		static {
			todos.add(new Todo(++todocount, "Ram","Learn Spring Boot",LocalDate.now().plusMonths(1),false));
			todos.add(new Todo(++todocount, "Ram","Learn JAVA",LocalDate.now().plusMonths(1),false));
		}
		public List<Todo> findByUsername(String username) {
			Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);

			return todos.stream().filter(predicate).toList();
		}
		public void addTodo(String username,String description,LocalDate targetdate,boolean done) {
			Todo todo = new Todo(++todocount,username,description,targetdate,done);
			todos.add(todo);
		}
		public void deleteById(int id) {
			Predicate<? super Todo> predicate = todo -> todo.getId()== id;
			todos.removeIf(predicate);
		}
		public Todo findById(int id) {
			Predicate<? super Todo> predicate = todo -> todo.getId()== id;
			Todo todo = todos.stream().filter(predicate).findFirst().get();
			return todo;
		}
		public void updateTodo(@Valid Todo todo) {
			deleteById(todo.getId());
			todos.add(todo);
		}
}
