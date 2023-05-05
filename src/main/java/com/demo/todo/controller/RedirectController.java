package com.demo.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

  @GetMapping("/")
  public String redirectToTodoList() {
    return "forward:/todos";
  }

}
