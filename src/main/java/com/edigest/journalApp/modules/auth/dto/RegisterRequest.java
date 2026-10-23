package com.edigest.journalApp.modules.auth.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class RegisterRequest {
  @NotBlank(message = "Username is Required")
  @Size(min = 3, max = 30, message = "Username must be between 3 and 30 charaters")
  public String userName;

  @NotBlank(message = "Email is Required")
  @Email(message = "Please provide a valid email")
  public String email;

  @NotBlank(message = "Password is Required")
  @Size(min = 3, max = 75, message = "Password must be between 3 and 75 charaters")
  public String password;

  //    pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
  @NotNull(message = "Please policy policy")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  public Date policyAcceptedAt;

  @NotNull(message = "Please accept policy")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  public Date termAcceptedAt;

  public Date getPolicyAcceptedAt() {
    return policyAcceptedAt;
  }

  public void setPolicyAcceptedAt(Date policyAcceptedAt) {
    this.policyAcceptedAt = policyAcceptedAt;
  }

  public Date getTermAcceptedAt() {
    return termAcceptedAt;
  }

  public void setTermAcceptedAt(Date termAcceptedAt) {
    this.termAcceptedAt = termAcceptedAt;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
