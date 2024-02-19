package com.ra.repository;

import com.ra.model.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository  extends JpaRepository<ToDo,Long> {
    List<ToDo> findByDescription(String name);
}
