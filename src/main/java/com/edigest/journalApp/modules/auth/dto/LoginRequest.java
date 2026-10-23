package com.edigest.journalApp.modules.auth.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {
  @NotBlank(message = "Username is Required")
  public String userName;

  @NotBlank(message = "Password is Required")
  public String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
