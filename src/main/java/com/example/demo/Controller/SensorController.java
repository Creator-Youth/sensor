package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/4-8:36 下午
 *
 */

import com.example.demo.Dao.BadSensor_Info;
import com.example.demo.Services.Jpa.BadSensorInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "sensor")
public class SensorController {

    @Autowired
    BadSensorInfoJpa badSensorInfoJpa;

    //查询损坏的传感器信息
    @GetMapping(value = "getAllInfo")
    @ResponseBody
    public List<BadSensor_Info> getAllInfo(){
        return badSensorInfoJpa.findAll();
    }
}
