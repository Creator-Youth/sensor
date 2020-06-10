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
@Table(name = "Admin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID；主键。
            Integer id;

    @Column
    String user_ud;

    @Column
    String admin_password;

    @Column
    String admin_number;


}
