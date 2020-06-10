package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-4:31 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Money_History")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
//存款取款历史记录
public class Money_History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
    Integer id;

    //操作时间
    @Column
    String data;

    //涉及金额
    @Column
    String money;

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
