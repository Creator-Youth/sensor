package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:09 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loginInfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class LoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String user_name;

    @Column
    private  String password;

    @Column
    private String role_name;

    @Column
    private  String name;

    LoginInfo(){

    }

    LoginInfo(int id, String user_name, String password, String role_name, String name){
        this.id=id;
        this.user_name=user_name;
        this.password=password;
        this.role_name=role_name;
        this.name=name;

    }
}
