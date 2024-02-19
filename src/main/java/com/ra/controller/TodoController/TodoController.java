package com.ra.controller.TodoController;

import com.ra.model.entity.ToDo;
import com.ra.service.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.image.TileObserver;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public ResponseEntity<List<ToDo>> getAll() {
        List<ToDo> toDoList = todoService.getAll();
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ToDo> createTodo(@RequestBody ToDo toDo) {
        ToDo toDoNew = todoService.save(toDo);
        return new ResponseEntity<>(toDoNew, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getId(@PathVariable Long id) {
        ToDo toDo= todoService.findById(id);
        return new ResponseEntity<>(toDo,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        todoService.delete(id);
        return new ResponseEntity<>("Xoa thanh cong ",HttpStatus.OK);
    }
    // update
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@PathVariable Long id,@RequestBody ToDo toDo){
        ToDo toDoUpDate=todoService.save(toDo);
        return new ResponseEntity<>(toDoUpDate,HttpStatus.OK);
    }
    // tim kiem theo ten
    @GetMapping("/search/{search}")
    public ResponseEntity<List<ToDo>> search(@PathVariable  String search){
        List<ToDo> toDoList=  todoService.findByName(search);
         return  new ResponseEntity<>(toDoList,HttpStatus.OK);
    }
}
