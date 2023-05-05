package com.demo.todo.enums;

public enum CreateUserResult {

  OK("Account created", false),
  USERNAME_TAKEN("Username is taken", true),
  PASSWORD_MISMATCH("Passwords do not match", true);

  private final String  message;
  private final boolean error;

  CreateUserResult(String message, boolean error) {
    this.message = message;
    this.error   = error;
  }

  public String getMessage() {
    return message;
  }

  public boolean isError() {
    return error;
  }

}
