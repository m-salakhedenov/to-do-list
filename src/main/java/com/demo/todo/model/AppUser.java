package com.demo.todo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String login;

  private String password;

  @OneToMany(mappedBy = "user")
  private List<TodoItem> todoItems;

  public AppUser() {
  }

  public AppUser(Long id, String login, String password, List<TodoItem> todoItems) {
    this.id        = id;
    this.login     = login;
    this.password  = password;
    this.todoItems = todoItems;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
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
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", todoItems=" + todoItems +
        '}';
  }

}
