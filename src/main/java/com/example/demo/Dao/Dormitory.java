package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-1:52 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dormitory")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Dormitory {
    //自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //楼层
    @Column
    private String dormitory_loucen;
}
