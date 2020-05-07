package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:20 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;

//前端统计信息
@Data
@Entity
@Table(name = "AllInfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })

//违纪传感器信息表
public class All_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //传感器编号
    @Column
    String sensor_id;

    //处理情况
    @Column
    Boolean judge;

    public All_Info(){}
}
