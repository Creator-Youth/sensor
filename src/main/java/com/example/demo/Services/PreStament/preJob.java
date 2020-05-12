package com.example.demo.Services.PreStament;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/11-4:41 下午
 *
 */

import com.example.demo.Dao.Data;
import com.example.demo.Dao.Sensor;
import com.example.demo.Dao.Student_Info;
import com.example.demo.Services.Jpa.DataJpa;
import com.example.demo.Services.Jpa.SensorJpa;
import com.example.demo.Services.Jpa.StudentinfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class preJob {
    @Autowired
    SensorJpa sensorJpa;

    @Autowired
    StudentinfoJpa studentinfoJpa;

    @Autowired
    DataJpa dataJpa;

    //楼层
    int stu_j =1;
    //宿舍
    int stu_k=1;
    //床位号
    int stu_z=1;
    public void preforSensor(){
        Sensor sensor = new Sensor();

        for(int i= 1;i<=840;i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SEN00");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            sensor.setSensor_id(stringBuffer.toString());
            sensorJpa.save(sensor);
            sensor = new Sensor();

        }
    }


    public void preStudentInfo(){
        Student_Info studentInfo = new Student_Info();
        for(int i =1;i<=840;i++){
            //传感器编号
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SEN00");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            studentInfo.setSensor_id(stringBuffer.toString());

            //学生姓名
            stringBuffer = new StringBuffer();
            stringBuffer.append("wwangxianhou");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            studentInfo.setStudent_name(stringBuffer.toString());

            //学生编号
            stringBuffer = new StringBuffer();
            stringBuffer.append("WXS00");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            studentInfo.setStudent_id(stringBuffer.toString());

            //老师编号
            stringBuffer = new StringBuffer();
            stringBuffer.append("TE00");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i/10);
            studentInfo.setTeacher_id(stringBuffer.toString());

            //老师姓名
            stringBuffer = new StringBuffer();
            stringBuffer.append("XSW00");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            studentInfo.setTeacher_name(stringBuffer.toString());

            //班级
            stringBuffer = new StringBuffer();
            stringBuffer.append("B1601");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i/30+1);
            studentInfo.setClass_name(stringBuffer.toString());

            //宿舍
            stringBuffer = new StringBuffer();
            stringBuffer.append(i/210+1); //四栋楼
            stringBuffer.append("-");
            stringBuffer.append(0);
            //
            if(stu_j==8){
                stu_j=1;
            }
            stringBuffer.append(stu_j++);
            if(stu_k==6){
                stu_k=1;
            }
            stringBuffer.append(0);
            stringBuffer.append(stu_k++);
            stringBuffer.append("-");
            if(stu_z==7){
                stu_z=1;
            }
            stringBuffer.append(stu_z++);
            studentInfo.setDormitory(stringBuffer.toString());
            studentinfoJpa.save(studentInfo);
            studentInfo = new Student_Info();
        }
    }

    public void preData(){
        Data data = new Data();
        List<Data> list = new ArrayList<>();
        for(int i =1;i<=840;i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SEN00");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            data.setSensor_id(stringBuffer.toString());

            //学生姓名
            stringBuffer = new StringBuffer();
            stringBuffer.append("wwangxianhou");
            if(i<10){
                stringBuffer.append("00");
            }else if(10<=i &&i<100){
                stringBuffer.append(0);
            }else{}
            stringBuffer.append(i);
            data.setStudent_name(stringBuffer.toString());
            data.setBed_id(1);
            data.setDormitory_id(1);
            data.setStudent_id(1);
            data.setHave_attend(1);

            Random random = new Random();
            int j =random.nextInt(50);
            if(j<=48){
                data.setHave_noise(1);
            }else{
                data.setHave_noise(0);
            }//
            int k =random.nextInt(50);
            if(k<=48){
                data.setHave_inbed(1);
            }else{
                data.setHave_inbed(0);
            }//
            int z =random.nextInt(50);
            if(z<=48){
                data.setHave_used(1);
            }else {
                data.setHave_used(0);
            }
            list.add(data);
            data = new Data();
        }
        dataJpa.saveAll(list);
    }
}
