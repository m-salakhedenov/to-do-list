package com.demo.todo.controller;

import com.demo.todo.service.TodoItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/todos")
public class TodoItemController {

  private final TodoItemService todoItemService;

  public TodoItemController(TodoItemService todoItemService) {
    this.todoItemService = todoItemService;
  }

  @GetMapping
  public String getAllTodoItems(Model model, Principal principal) {
    model.addAttribute("todos", todoItemService.getAllTodoItems(principal));
    return "todo/list";
  }

  @PostMapping
  public String saveTodo(@RequestParam String title, Principal principal) {
    todoItemService.addTodoItem(title, principal);
    return "redirect:/todos";
  }

  @GetMapping("/complete/{todoItemId}")
  public String completeTodo(@PathVariable long todoItemId) {
    todoItemService.markCompleted(todoItemId);
    return "redirect:/todos";
  }

  @GetMapping("/delete/{todoItemId}")
  public String deleteTodo(@PathVariable long todoItemId) {
    todoItemService.deleteTodoItem(todoItemId);
    return "redirect:/todos";
  }

}
