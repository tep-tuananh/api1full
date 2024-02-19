package com.ra.service.TodoService;

import com.ra.model.entity.ToDo;
import com.ra.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public List<ToDo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public List<ToDo> findByName(String name) {
        return todoRepository.findByDescription(name);
    }

    @Override
    public ToDo save(ToDo toDo) {
        return todoRepository.save(toDo);
    }

    @Override
    public ToDo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
