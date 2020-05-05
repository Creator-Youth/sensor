package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/4-8:36 下午
 *
 */

import com.example.demo.Dao.BadSensor_Info;
import com.example.demo.Dao.Sensor;
import com.example.demo.Services.Jpa.BadSensorInfoJpa;
import com.example.demo.Services.Jpa.SensorJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "sensor")
public class SensorController {

    @Autowired
    SensorJpa sensorJpa;

    @Autowired
    BadSensorInfoJpa badSensorInfoJpa;

    //查询损坏的传感器信息
    @GetMapping(value = "getAllInfo")
    @ResponseBody
    public List<BadSensor_Info> getAllInfo(){
        return badSensorInfoJpa.findAll();
    }

    //查询损坏的传感器信息
    @PostMapping(value = "getInfoBySensorID")
    @ResponseBody
    public List<BadSensor_Info> getInfoBySensorID(@RequestParam("sensorId")String sensorId){
        List<BadSensor_Info> list = new ArrayList<>();
        list.add(badSensorInfoJpa.getById(sensorId));
        return list;
    }

    //添加传感器
    @PostMapping(value = "saveSensor")
    @ResponseBody
    public Boolean saveSensor(@RequestParam("sensorName") String sensorName){
        Sensor sensor = new Sensor();
        sensor.setSensor_name(sensorName);
        try{
            sensorJpa.save(sensor);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    //删除传感器
    @PostMapping
    @ResponseBody
    public boolean deletebyNmae(@RequestParam("sensorName") String sensorName){
        Sensor sensor = sensorJpa.getByName(sensorName);
        if(null==sensor){
            return false;
        }try{
            sensorJpa.deleteById(sensor.getId());
        }catch (Exception e){
            return false;
        }
        return true;

    }

}
