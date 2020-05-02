package com.example.demo.Dao;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:24 下午
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

//前端老师管理页面
@Data
@Entity
@Table(name = "TeacherInfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Teacher_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    //老师编号
    @Column
    String teacher_id;

    //老师姓名
    @Column
    String teacher_name;

    //老师联系方式
    @Column
    String teacher_dormitory;

    //老师班级
    @Column
    String class_name;

    //老师性别
    @Column
    String gender;

    Teacher_Info(int id,String teacher_name,String teacher_id,String teacher_dormitory,
                 String class_name,String gender){
        this.id=id;
        this.class_name=class_name;
        this.teacher_dormitory=teacher_dormitory;
        this.teacher_id=teacher_id;
        this.class_name=teacher_name;
        this.teacher_name=teacher_name;
    }

    Teacher_Info(){}

}
