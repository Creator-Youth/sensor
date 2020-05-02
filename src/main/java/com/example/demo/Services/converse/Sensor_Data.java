package com.example.demo.Services.converse;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:21 下午
 *
 */

import com.example.demo.Dao.Data;
import com.example.demo.Dao.Sensor_Info;

//传感器信息与自定义信息之间的转换
public class Sensor_Data {

    public Sensor_Info DataToSensor(Data data){
        Sensor_Info sensorInfo = new Sensor_Info();

        sensorInfo.setId(data.getId());

        sensorInfo.setStudent_name(data.getStudent_name());

        //写死
        sensorInfo.setSensor_id("SEN0001");

        //写死
        sensorInfo.setIs_good(false);

        sensorInfo.setIs_noise(data.getHave_noise()==1? true:false);

        sensorInfo.setIs_bed(data.getHave_inbed()==1 ? true:false);

        sensorInfo.setIs_light(data.getHave_used()==1 ? true:false);

        return sensorInfo;

    }
}
