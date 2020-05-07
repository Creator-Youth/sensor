package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:11 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
//前端传感器信息
@Entity
@Table(name = "SensorInfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
//数据处理表
public class Sensor_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //传感器ID
    @Column
    String sensor_id;

    //学生姓名
    @Column
    String student_name;

    //学生班主任
    @Column
    String teacher_name;

    //是否在床上
    @Column
    Boolean is_bed;

    //是否在说话
    @Column
    Boolean is_noise;

    //是否熄灯
    @Column
    Boolean is_light;

    //是否损坏
    @Column
    Boolean is_good;

    public Sensor_Info(){}


}
