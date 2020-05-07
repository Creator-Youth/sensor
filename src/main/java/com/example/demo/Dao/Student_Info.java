package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:06 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

//前端界面，学生信息
@Data
@Entity
@Table(name = "StudentInfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
//学生信息表

public class Student_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //学号
    @Column
    String student_id;

    //学生姓名
    @Column
    String student_name;

    //传感器编号
    @Column
    String sensor_id;

    //老师编号
    @Column
    String teacher_id;

    //学生班级
    @Column
    String class_name;

    //老师姓名
    @Column
    String teacher_name;

    //学生宿舍
    @Column
    String dormitory;

    public Student_Info(){

    }

    Student_Info(int id,String stdent_id, String student_name,String sensor_id,
                 String teacher_id,String teacher_name,String dormitory){
        this.dormitory=dormitory;
        this.id=id;
        this.sensor_id=sensor_id;
        this.student_id=stdent_id;
        this.student_name=student_name;
        this.teacher_id=teacher_id;
        this.teacher_name=teacher_name;
    }

}
