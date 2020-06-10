package com.example.demo.po;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-11:06 上午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 银行用户登录表
 */
@Entity
@Table(name = "user_account")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_password")
  private String userPassword;


  public UserAccount() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Integer getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getUserPassword() {
    return userPassword;
  }
}
