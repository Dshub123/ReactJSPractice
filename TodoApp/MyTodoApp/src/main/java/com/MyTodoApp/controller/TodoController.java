package com.MyTodoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyTodoApp.entities.Todo;
import com.MyTodoApp.entities.User;
import com.MyTodoApp.services.TodoServices;

@RestController
@RequestMapping("/todo")
public class TodoController
{
	@Autowired
	private TodoServices todoServices;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createTodo(@RequestBody Todo todo)
	{
		System.out.println(todo);
		return new ResponseEntity<>(todoServices.createTodo(todo),HttpStatus.CREATED);
	}
	
//	@GetMapping("/gets")
//	public ResponseEntity<?>   getAllTodo()
//	{
//		return new ResponseEntity<>(todoServices.getAllTodo(),HttpStatus.OK);
//	}
	
	
	@PostMapping("/list-All-todo")
	public ResponseEntity<?>  listAllTodo(@RequestBody User user)
	{
		return ResponseEntity.ok(todoServices.listAllTodos(user));
	}

	@GetMapping("/{todoId}")
	public ResponseEntity<?> getTodoById(@PathVariable("todoId") Long id){

		return ResponseEntity.ok(todoServices.getById(id));
	}
	
	
	@PutMapping("/update/{todoId}")
	public ResponseEntity<?> updateTodo(@PathVariable("todoId")Long id,
			                            @RequestBody Todo todo)
	{
		System.out.println(todo);
		Todo updateTodo = todoServices.updateTodo(id,todo);
		return new ResponseEntity<>(updateTodo,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{todoId}")
	public String deleteTodo(@PathVariable("todoId")Long id)
	{
		
		todoServices.deleteTodo(id);
		return "deleted successfully";
		
	}
 }
