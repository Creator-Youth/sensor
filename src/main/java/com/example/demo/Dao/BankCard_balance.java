package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-11:11 上午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BankCard_balance")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BankCard_balance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
            Integer id;

    @Column
    //卡号ID，外建
    Integer bankCard_id;

    @Column
    // 余额
    Double money;

}
