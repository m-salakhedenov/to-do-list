package com.demo.todo.service;

import com.demo.todo.dto.TodoItemDto;
import com.demo.todo.model.AppUser;
import com.demo.todo.model.TodoItem;
import com.demo.todo.repository.AppUserRepository;
import com.demo.todo.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoItemService {

  private final TodoItemRepository todoItemRepository;
  private final AppUserRepository  appUserRepository;

  public TodoItemService(TodoItemRepository todoItemRepository, AppUserRepository appUserRepository) {
    this.todoItemRepository = todoItemRepository;
    this.appUserRepository  = appUserRepository;
  }

  public List<TodoItemDto> getAllTodoItems(Principal principal) {
    return appUserRepository.findByUsername(principal.getName())
        .orElseThrow()
        .getTodoItems()
        .stream()
        .map(TodoItemService::mapToDto)
        .collect(Collectors.toList());
  }

  public void addTodoItem(String title, Principal principal) {
    AppUser author = appUserRepository.findByUsername(principal.getName())
        .orElseThrow();

    TodoItem todoItem = new TodoItem();
    todoItem.setTitle(title);
    todoItem.setUser(author);

    todoItemRepository.save(todoItem);
  }

  public void markCompleted(long todoItemId) {
    TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow();
    todoItem.setCompleted(true);
    todoItemRepository.save(todoItem);
  }

  public void deleteTodoItem(long todoItemId) {
    todoItemRepository.deleteById(todoItemId);
  }

  private static TodoItemDto mapToDto(TodoItem todoItem) {
    return new TodoItemDto(todoItem);
  }

}
