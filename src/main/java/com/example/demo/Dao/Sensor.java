package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/5-9:07 下午
 *
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Sensor")
//所有传感器
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //自增ID
    int id;

    @Column
    //传感器编号
    String sensor_id;
}
