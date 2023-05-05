package com.demo.todo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

  @OneToMany(mappedBy = "user")
  private List<TodoItem> todoItems;

  public AppUser() {
  }

  public AppUser(Long id, String username, String password, List<TodoItem> todoItems) {
    this.id        = id;
    this.username  = username;
    this.password  = password;
    this.todoItems = todoItems;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<TodoItem> getTodoItems() {
    return todoItems;
  }

  public void setTodoItems(List<TodoItem> todoItems) {
    this.todoItems = todoItems;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", login='" + username + '\'' +
        ", password='" + password + '\'' +
        ", todoItems=" + todoItems +
        '}';
  }

}
