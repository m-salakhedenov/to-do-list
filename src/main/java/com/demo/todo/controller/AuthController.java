package com.demo.todo.controller;

import com.demo.todo.dto.SignupRequestDto;
import com.demo.todo.enums.CreateUserResult;
import com.demo.todo.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

  private final AppUserService userService;

  public AuthController(AppUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String loginPage() {
    return "auth/login";
  }

  @GetMapping("/signup")
  public String signupPage() {
    return "auth/signup";
  }

  @PostMapping("/signup")
  public String signup(@ModelAttribute SignupRequestDto signupRequest, RedirectAttributes redirectAttributes) {
    CreateUserResult result = userService.createUser(signupRequest);

    redirectAttributes.addFlashAttribute("result", result);

    return "redirect:/auth/signup";
  }

}
