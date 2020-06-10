package com.example.demo.po;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-11:11 上午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Admin {

  //自增ID；主键。
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "admin_password")
  private String adminPassword;

  @Column(name = "admin_number")
  private String adminNumber;

  public Admin() {
  }

  public Integer getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getAdminPassword() {
    return adminPassword;
  }

  public String getAdminNumber() {
    return adminNumber;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }

  public void setAdminNumber(String adminNumber) {
    this.adminNumber = adminNumber;
  }
}
