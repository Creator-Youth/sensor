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
@Table(name = "user_info")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class UserInfo {

  //自增ID；主键。
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;


  @Column(name = "user_id")
  private String userId;

  //真实姓名
  @Column(name = "user_real_name")
  private String userRealName;

  //身份证号
  @Column(name = "user_id_card")
  private String userIdCard;

  //用户电话号码
  @Column(name = "user_tel")
  private String userTel;

  //用户地址
  @Column(name = "user_address")
  private String userAddress;

  public UserInfo() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setUserRealName(String userRealName) {
    this.userRealName = userRealName;
  }

  public void setUserIdCard(String userIdCard) {
    this.userIdCard = userIdCard;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public Integer getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getUserRealName() {
    return userRealName;
  }

  public String getUserIdCard() {
    return userIdCard;
  }

  public String getUserTel() {
    return userTel;
  }

  public String getUserAddress() {
    return userAddress;
  }
}
