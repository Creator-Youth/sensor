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
@Table(name = "Bank_card")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Bank_Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
    Integer id;

    @Column
    //外建
    Integer user_id;

    @Column
    //卡号
    String bankCard_number;

    @Column
    //六位密码，varchar(6)
    String bankCard_password;

    @Column
    //删卡标记
    Boolean card_flag;

}
