package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/4-8:36 下午
 *
 */
import com.example.demo.Dao.*;
import com.example.demo.Services.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping(value = "sensor")
public class SensorController {

    @Autowired
    StudentinfoJpa studentinfoJpa;

    @Autowired
    SensorJpa sensorJpa;

    @Autowired
    BadSensorInfoJpa badSensorInfoJpa;

    @Autowired
    AllInfoJpa allInfoJpa;

    @Autowired
    DataJpa dataJpa;

    //查询所有损坏的传感器信息
    @GetMapping(value = "getAllBadInfo")
    @ResponseBody
    public List<BadSensor_Info> getAllInfo(){
        Pageable pageable =PageRequest.of(0,20);
        Page<BadSensor_Info> page = badSensorInfoJpa.findAll(pageable);
        return page .getContent();
    }

    //查询传感器违纪信息
    @PostMapping(value = "getInfoBySensorID")
    @ResponseBody
    public List<BadSensor_Info> getInfoBySensorID(@RequestParam("sensorId")String sensorId){
        List<BadSensor_Info> list = new ArrayList<>();
        BadSensor_Info badSensorInfo =new BadSensor_Info();
        Data data = null;
        try{
              data=dataJpa.getDataBySensorID (sensorId);
        }catch (Exception e){
        }
        if(null == data){
            return new ArrayList<>();
        }else{
            badSensorInfo.setStudent_name(data.getStudent_name());
            badSensorInfo.setTeacher_name(studentinfoJpa
                    .getBySensorName(data.getSensor_id())
                    .getTeacher_name());
            badSensorInfo.setSensor_id(data.getSensor_id());
            badSensorInfo.setIs_light(data.getHave_used()==1);
            badSensorInfo.setIs_bed(data.getHave_inbed()==1);
            badSensorInfo.setIs_noise(data.getHave_noise()==1);
            badSensorInfo.setIs_good(true);
            list.add(badSensorInfo);
            return list;
        }
    }

    //添加传感器
    @PostMapping(value = "saveSensor")
    @ResponseBody
    public String saveSensor(@RequestParam("sensorName") String sensorName){
        Sensor sensor = new Sensor();
        if(null !=sensorJpa.getBySensorId(sensorName)){
            return "数据重复，添加失败";
        }
        sensor.setSensor_id(sensorName);
        sensor=sensorJpa.save(sensor);
        if(sensor.getId()>0){
            return "添加成功";
        }else{
            return "添加失败，请检查刷新重试";
        }
    }

    //删除传感器
    @PostMapping(value = "deleteByName")
    @ResponseBody
    public String  deletebyNmae(@RequestParam("sensorName") String sensorName){
        Sensor sensor = sensorJpa.getBySensorId(sensorName);
        if(null==sensor){
            return "数据不存在";
        }try{
            sensorJpa.deleteById(sensor.getId());
            Student_Info studentInfo= studentinfoJpa.getBySensorName(sensor.getSensor_id());
            studentinfoJpa.delete(studentInfo);

        }catch (Exception e){
            return "删除失败，请检查重试";
        }
        return "删除成功";

    }

    //处理违纪
    @PostMapping(value = "deleteAllInfoById")
    @ResponseBody
    public String deleteAllInfoById(@RequestParam("sensor_id") String sensor_id){
        try{
            allInfoJpa.deleteById(allInfoJpa.getAllInfoById(sensor_id).getId());
        }catch (Exception e){
            return "处理失败";
        }
        return "处理成功";
    }


    //所有违纪传感器
    @GetMapping(value = "getInfo")
    @ResponseBody
    public List<All_Info> getinfo(){
        return allInfoJpa.findAll();
    }

}
