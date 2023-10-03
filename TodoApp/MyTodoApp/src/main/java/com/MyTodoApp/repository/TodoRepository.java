package com.MyTodoApp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MyTodoApp.entities.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>
{

	@Query("FROM Todo t LEFT JOIN User u ON t.userId = u.id WHERE u.id = :userId")
    List<Todo> findAllTodoByUserId(@Param("userId") Long userId);
}
