package com.MyTodoApp.services;

import java.util.List;
import java.util.Optional;

import com.MyTodoApp.entities.Todo;
import com.MyTodoApp.entities.User;

public interface TodoServices
{

	Todo createTodo(Todo todo);

	//List<Todo> getAllTodo();

	Todo updateTodo(Long id, Todo todo);

	void deleteTodo(Long id);

	List<Todo> listAllTodos(User user);


    Optional<Todo> getById(Long id);
}
