package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午1:49
 * @Description:
 */

@Entity(value = "USERS")
public class UserEntity {
  @Property(value = "ROW")
  private String id;

  @Property(value = "email")
  private String email;

  @Property(value = "password")
  private String password;

  @Property(value = "user")
  private String user;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
      "id='" + id + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", user='" + user + '\'' +
      '}';
  }
}
