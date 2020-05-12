package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:32 下午
 *
 */

import com.example.demo.Dao.*;
import com.example.demo.Services.Jpa.*;
import com.example.demo.Services.PreStament.preJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    DormitoryJpa dormitoryJpa;

    @Autowired
    preJob prejob;

    @Autowired
    SensorJpa sensorJpa;

    @Autowired
    BadSensorInfoJpa badSensorInfoJpa;

    @Autowired
    DataJpa dataJpa;

    @Autowired
    StudentinfoJpa studentinfoJpa;

    @Autowired
    AllInfoJpa allInfoJpa;
    @Autowired
    private LoginInfoJpa loginInfoJpa;

    @PostMapping(value = "/getAllById")
    @ResponseBody
    public LoginInfo getById(int id){
        return loginInfoJpa.getOne(id);
    }


    /*验证登录接口*/
    @PostMapping(value = "/getPasswordByusername")
    @ResponseBody
    public Boolean getPasswordByUsername(@RequestParam("user_name") String user_name, @RequestParam("password") String password){

       //prejob.preData();
       // prejob.preforSensor();
        //prejob.preStudentInfo();
        /*if(allInfoJpa.count()<1){
            preLogin();
        }*/
        Dormitory dormitory = new Dormitory();
        /*for(int i =1;i<=20;i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            dormitory.setDormitory_loucen(stringBuffer.toString());
            dormitoryJpa.save(dormitory);
            dormitory=new Dormitory();

        }*/
        LoginInfo loginInfo = loginInfoJpa.findbyUsername(user_name);
        if(null == loginInfo){
            return false;
        }
        if(loginInfo.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public void preLogin(){

        //获取数据库里面的所有传感器传感器
        List<String> sensorList = sensorJpa.findAllSensorId();

        //获取能够接收信息的所有传感器
        List<String > dataList = dataJpa.findAllSensorId();
        //所有传感器信息

        List<String> list1 = dataJpa.getByNoise(0);
        List<String> list2 = dataJpa.getByBed(0);
        List<String> list3 = dataJpa.getByUsed(0);
        list1.addAll(list2);
        list1.addAll(list3);
        HashSet<String> ser_allInfo = new HashSet<>(list1);  //违纪信息
        List<All_Info> allinfoList = new ArrayList<>();
        All_Info allInfo = new All_Info();
        for (String sensorId : ser_allInfo
             ) {
            allInfo.setSensor_id(sensorId);
            allInfo.setJudge(false);
            allinfoList.add(allInfo);
            allInfo = new All_Info();
        }
        allInfoJpa.saveAll(allinfoList);

        sensorList.removeAll(dataList);
        List<BadSensor_Info> list = new ArrayList<>();
        for(String sensorid : sensorList){
                BadSensor_Info badSensorInfo = new BadSensor_Info();
                badSensorInfo.setIs_bed(false);
                badSensorInfo.setIs_good(false);
                badSensorInfo.setIs_noise(false);
                badSensorInfo.setIs_light(false);
                badSensorInfo.setSensor_id(sensorid);
                Student_Info studentInfo = studentinfoJpa.getBySensorName(sensorid);
                badSensorInfo.setStudent_name(studentInfo.getStudent_name()); // 学生姓名;
                badSensorInfo.setTeacher_name(studentInfo.getTeacher_name()); //  获取老师姓名
                list.add(badSensorInfo);
        }
        badSensorInfoJpa.saveAll(list);
    }

    public void postSignOut(){
        allInfoJpa.deleteAll();
        badSensorInfoJpa.deleteAll();
    }





}
