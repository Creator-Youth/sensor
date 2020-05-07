package com.example.demo.Services;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/7-3:16 下午
 *
 */

import com.example.demo.Dao.*;
import com.example.demo.Services.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Prepare {
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

    public Prepare(){

    }
    public void preLogin(){
        //获取数据库里面的所有传感器传感器
        List<Sensor> preSensorList = sensorJpa.findAll();
        //获取能够接收信息的所有传感器
        List<Data> preDataList = dataJpa.findAll();
        //获取损坏传感器的信息
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String,String> hashMap = new HashMap<>();
        for ( Data data: preDataList
             ) {
            if(data.getHave_inbed() ==0 || data.getHave_noise()==0 || data.getHave_used()==0){
                All_Info allInfo = new All_Info();
                allInfo.setSensor_id(data.getSensor_id());
                allInfo.setJudge(false);
                allInfoJpa.save(allInfo);

            }
            hashSet.add(data.getSensor_id());
            hashMap.put(data.getSensor_id(),data.getStudent_name());
        }

        List<BadSensor_Info> list = new ArrayList<>();

        for(Sensor sensor:preSensorList){
            if(hashSet.contains(sensor.getSensor_id())){
                continue;
            }else{
                BadSensor_Info badSensorInfo = new BadSensor_Info();
                badSensorInfo.setIs_bed(false);
                badSensorInfo.setIs_good(false);
                badSensorInfo.setIs_noise(false);
                badSensorInfo.setIs_light(false);
                badSensorInfo.setSensor_id(sensor.getSensor_id());
                badSensorInfo.setStudent_name(hashMap.get(sensor.getSensor_id())); // 学生姓名;
                badSensorInfo.setTeacher_name(
                        studentinfoJpa.getBySensorName(
                                sensor.getSensor_id())
                                .getTeacher_name()); //  获取老师姓名
                list.add(badSensorInfo);
            }
        }
        //更新损坏传感器信息表
        badSensorInfoJpa.saveAll(list);
    }
}
