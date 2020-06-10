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
@Table(name = "User_Info")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
    Integer id;

    @Column
    String user_id;

    @Column
    String user_realName;

    @Column
    String user_IDCard;

    @Column
    String user_tel;

    @Column
    String user_address;

}
