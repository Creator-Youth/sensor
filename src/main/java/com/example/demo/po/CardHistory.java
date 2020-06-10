package com.example.demo.po;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:26 下午
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
@Table(name = "card_history")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class CardHistory {

  //自增ID；主键。
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //操作时间
  @Column
  private String data;

  //操作人
  @Column
  private String user;

  //具体操作
  @Column
  private String action;

  //银行卡号
  @Column(name = "bank_id")
  private String bankId;

  public CardHistory() {
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setData(String data) {
    this.data = data;
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
