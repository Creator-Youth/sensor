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

/**
 *  @author huajishaonian
 *  @author Liu YaXue
 */

@Entity
@Table(name = "bank_card")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class BankCard {

  //自增ID；主键。
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //外建
  @Column(name = "user_id")
  private Integer userId;

  //卡号
  @Column(name = "bank_card_number")
  private String bankCardNumber;

  //六位密码，varchar(6)
  @Column(name = "bank_card_password")
  private String bankCardPassword;

  //删卡标记
  @Column(name = "card_flag")
  private Boolean cardFlag;

  public BankCard() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public void setBankCardNumber(String bankCardNumber) {
    this.bankCardNumber = bankCardNumber;
  }

  public void setBankCardPassword(String bankCardPassword) {
    this.bankCardPassword = bankCardPassword;
  }

  public void setCardFlag(Boolean cardFlag) {
    this.cardFlag = cardFlag;
  }

  public Integer getId() {
    return id;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getBankCardNumber() {
    return bankCardNumber;
  }

  public String getBankCardPassword() {
    return bankCardPassword;
  }

  public Boolean getCardFlag() {
    return cardFlag;
  }
}
