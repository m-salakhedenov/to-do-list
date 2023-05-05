package com.demo.todo.service;

import com.demo.todo.dto.SignupRequestDto;
import com.demo.todo.enums.CreateUserResult;
import com.demo.todo.model.AppUser;
import com.demo.todo.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AppUserService {

  private final AppUserRepository appUserRepository;
  private final PasswordEncoder   passwordEncoder;

  public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
    this.appUserRepository = appUserRepository;
    this.passwordEncoder   = passwordEncoder;
  }

  public CreateUserResult createUser(SignupRequestDto signupRequestDto) {
    if (!Objects.equals(signupRequestDto.getPassword(), signupRequestDto.getRepeatPassword())) {
      return CreateUserResult.PASSWORD_MISMATCH;
    }

    Optional<AppUser> dbUser = appUserRepository.findByUsername(signupRequestDto.getUsername());

    if (dbUser.isPresent()) {
      return CreateUserResult.USERNAME_TAKEN;
    }

    AppUser appUser = new AppUser(
        signupRequestDto.getUsername(),
        passwordEncoder.encode(signupRequestDto.getPassword())
    );

    appUserRepository.save(appUser);

    return CreateUserResult.OK;
  }

}
