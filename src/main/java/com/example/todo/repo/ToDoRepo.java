package com.example.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long>{
    
}
