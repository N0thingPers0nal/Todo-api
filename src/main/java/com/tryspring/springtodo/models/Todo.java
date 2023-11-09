package com.tryspring.springtodo.models;

public class Todo {
    private int id;
    private String item;
    private Boolean delete_flag;

    public Todo(int id, String item, Boolean delete_flag) {
        this.id = id;
        this.item = item;
        this.delete_flag = delete_flag;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Boolean delete_flag) {
        this.delete_flag = delete_flag;
    }
}
