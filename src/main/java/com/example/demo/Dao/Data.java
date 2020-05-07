package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:03 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@lombok.Data
@Entity
@Table(name = "data")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
//传感器接收信息表
public class Data {
    //自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //学号
    @Column
    private int student_id;

    //学生姓名
    @Column
    private String student_name;

    //宿舍号
    @Column
    private int dormitory_id;

    //床位
    @Column
    private int  bed_id;

    //是否签到
    @Column
    private int have_attend;

    //是否在床上
    @Column
    private int have_inbed;

    //是否使用电子产品
    @Column
    private int have_used;

    //是否吵闹
    @Column
    private int have_noise;

    @Column
    //传感器ID
    private String sensor_id;

}
