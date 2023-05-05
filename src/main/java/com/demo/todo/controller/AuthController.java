package com.demo.todo.controller;

import com.demo.todo.dto.SignupRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

  @GetMapping("/login")
  public String loginPage() {
    return "auth/login";
  }

  @GetMapping("/signup")
  public String signupPage() {
    return "auth/signup";
  }

  @PostMapping("/signup")
  public String signup(@ModelAttribute SignupRequestDto signupRequest, Model model) {

    return "redirect:auth/signup";
  }

}
