package com.ra.service.TodoService;

import com.ra.model.entity.ToDo;

import java.util.List;

public interface TodoService {
    List<ToDo> getAll();
    ToDo save(ToDo toDo);
    ToDo findById(Long id);
    void delete(Long id);
    List<ToDo> findByName(String name);
}
