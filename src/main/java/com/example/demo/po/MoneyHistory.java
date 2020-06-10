package com.example.demo.po;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-4:31 下午
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
@Table(name = "money_history")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
//存款取款历史记录
public class MoneyHistory {

  //自增ID；主键。
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //操作时间
  @Column
  private String data;

  //涉及金额
  @Column
  private String money;

  //操作人
  @Column
  private String user;

  //具体操作
  @Column
  private String action;

  //银行卡号
  @Column(name = "bank_id")
  private String bankId;

  public void setId(Integer id) {
    this.id = id;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setMoney(String money) {
    this.money = money;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }

  public Integer getId() {
    return id;
  }

  public String getData() {
    return data;
  }

  public String getMoney() {
    return money;
  }

  public String getUser() {
    return user;
  }

  public String getAction() {
    return action;
  }

  public String getBankId() {
    return bankId;
  }
}
