package com.example.demo.po;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:26 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "card_history")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
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

}
