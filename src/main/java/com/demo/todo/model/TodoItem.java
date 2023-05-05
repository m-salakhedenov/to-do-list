package com.demo.todo.model;

import jakarta.persistence.*;

@Entity
public class TodoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private boolean completed;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private AppUser user;

  public TodoItem() {
  }

  public TodoItem(Long id, String title, boolean completed, AppUser user) {
    this.id        = id;
    this.title     = title;
    this.completed = completed;
    this.user      = user;
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

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "TodoItem{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", completed=" + completed +
        ", user=" + user +
        '}';
  }

}
