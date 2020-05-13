package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-10:30 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@lombok.Data
@Entity
@Table(name = "History")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String student_id;

    @Column
    private String student_name;

    @Column
    private String time;

}
