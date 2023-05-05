package com.demo.todo.dto;

import com.demo.todo.model.TodoItem;

public class TodoItemDto {

  private Long    id;
  private String  title;
  private boolean completed;

  public TodoItemDto() {
  }

  public TodoItemDto(TodoItem todoItem) {
    this.id        = todoItem.getId();
    this.title     = todoItem.getTitle();
    this.completed = todoItem.isCompleted();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  @Override
  public String toString() {
    return "TodoItemDto{" +
        "title='" + title + '\'' +
        ", completed=" + completed +
        '}';
  }

}
