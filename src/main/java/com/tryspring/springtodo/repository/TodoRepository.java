package com.tryspring.springtodo.repository;

import com.tryspring.springtodo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * FROM todoList WHERE delete_flag=false", new BeanPropertyRowMapper<>(Todo.class));
    }


    public Todo findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM todoList WHERE id=? and delete_flag=false;", new Object[]{id}, new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insert(Todo todo) {
        jdbcTemplate.update("INSERT INTO todoList(item) VALUES(?)", new Object[]{todo.getItem()});
        return findAll();
    }

    public List<Todo> update(Todo todo) {
        jdbcTemplate.update("UPDATE todoList SET item=? WHERE id=?", new Object[]{todo.getItem(), todo.getId()});
        return findAll();
    }

    public List<Todo> deleteTodoById(int id) {
        jdbcTemplate.update("UPDATE todoList SET delete_flag=true WHERE id=?", new Object[]{id});
        return findAll();
    }
}
