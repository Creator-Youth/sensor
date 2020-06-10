package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:26 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Card_History")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Card_History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
            Integer id;

    //操作时间
    @Column
    String data;

    //操作人
    @Column
    String user;

    //具体操作
    @Column
    String action;

    //银行卡号
    @Column
    String bankID;
}
