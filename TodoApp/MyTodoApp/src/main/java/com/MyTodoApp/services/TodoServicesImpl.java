package com.MyTodoApp.services;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyTodoApp.entities.Todo;
import com.MyTodoApp.entities.User;
import com.MyTodoApp.repository.TodoRepository;


@Service
public class TodoServicesImpl implements TodoServices
{
	@Autowired
	private TodoRepository todoRepository;
	
	

	@Override
	public Todo createTodo(Todo todo) 
	{
		System.out.println(todo);
		todo.setTargetDate(LocalDate.now());
		return todoRepository.save(todo);
	}

	@Override
	public List<Todo> listAllTodos(User user)
	{
		
		return todoRepository.findAllTodoByUserId(user.getId());
	}

	@Override
	public Optional<Todo> getById(Long id) {
		return todoRepository.findById(id);
	}


//	@Override
//	public List<Todo> getAllTodo() 
//	{
//		
//		 List<Todo> findAll = todoRepository.findAll();
//		 System.out.println(findAll);
//		return findAll;
//	}

	@Override
	public Todo updateTodo(Long id, Todo todo) 
	{
		Todo  todos = todoRepository.findById(id).get();
		
		todos.setDescription(todo.getDescription());
		todos.setIsDone(todo.getIsDone());	
		todos.setUserId(todo.getUserId());
		//todos.setTargetDate(todo.getTargetDate());
		
		System.out.println("After update"+todos);
		
		todos.setTargetDate(LocalDate.now());
		return todoRepository.save(todos);
	}

	@Override
	public void deleteTodo(Long id)
	{
		todoRepository.deleteById(id);
		
	}

	

}
