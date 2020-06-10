package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-11:06 上午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User_Account")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User_Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
            Integer id;

    @Column
    String user_name;

    @Column
    String user_password;

}
