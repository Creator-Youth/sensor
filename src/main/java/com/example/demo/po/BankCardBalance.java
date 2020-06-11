package com.example.demo.po;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-11:11 上午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_card_balance")
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class BankCardBalance {

  //自增ID；主键。
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //卡号ID，外建
  @Column(name = "bank_card_id")
  private String bankCardId;

  // 余额
  @Column(name = "money")
  private Double money;

  public BankCardBalance() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setBankCardId(String  bankCardId) {
    this.bankCardId = bankCardId;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  public Integer getId() {
    return id;
  }

  public String getBankCardId() {
    return bankCardId;
  }

  public Double getMoney() {
    return money;
  }
}
