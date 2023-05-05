package com.demo.todo.dto;

public class SignupRequestDto {

  private String username;
  private String password;
  private String repeatPassword;

  public SignupRequestDto() {
  }

  public SignupRequestDto(String username, String password, String repeatPassword) {
    this.username       = username;
    this.password       = password;
    this.repeatPassword = repeatPassword;
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

  public String getRepeatPassword() {
    return repeatPassword;
  }

  public void setRepeatPassword(String repeatPassword) {
    this.repeatPassword = repeatPassword;
  }

  @Override
  public String toString() {
    return "SignupRequestDto{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", repeatPassword='" + repeatPassword + '\'' +
        '}';
  }

}
