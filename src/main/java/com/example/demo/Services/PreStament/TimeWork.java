package com.example.demo.Services.PreStament;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/17-9:16 下午
 *
 */

import com.example.demo.Dao.All_Info;
import com.example.demo.Dao.History;
import com.example.demo.Dao.Student_Info;
import com.example.demo.Services.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

//本部分用于设计定时任务,用于数据更新功能；
@Component
@EnableScheduling
public class TimeWork {
    @Autowired
    preJob pre;

    @Autowired
    AllInfoJpa allInfoJpa;

    @Autowired
    BadSensorInfoJpa badSensorInfoJpa;

    @Autowired
    DataJpa dataJpa;

    @Autowired
    GetCache getCache;

    @Autowired
    StudentinfoJpa studentinfoJpa;

    @Autowired
    HistoryJpa historyJpa;


    @Scheduled(cron="0 57 12 ? * *")//秒、分、时、日期、月份、星期、年份（可省略）
    //更新数据库违纪信息（设置每天十点十分执行）
    public void prePareWork1(){
        saveHistory();
    }

    @Scheduled(cron="0 10 11 ? * *")//秒、分、时、日期、月份、星期、年份（可省略）
    //更新数据库违纪信息（设置每天十一点十分执行）
    public void prePareWork2(){
        saveHistory();
    }

    @Scheduled(cron="0 10 12 ? * *")//秒、分、时、日期、月份、星期、年份（可省略）
    //更新数据库违纪信息（设置每天十二点十分执行）
    public void prePareWork3(){
        saveHistory();
    }

    public void saveHistory(){
        Calendar cal = Calendar.getInstance();
        Date data = cal.getTime();
        String DEFAULT_PATTERN ="yyyy-MM-dd-hh"; //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        String time = sdf.format(data);
        History history = new History();
        List<String> list = getCache.getAddInfo();
        if(list.size()==0){
            return;
        }
        for(String sensor_id:list){
            Student_Info studentInfo = studentinfoJpa.getBySensorName(sensor_id);
            history.setTime(time);
            history.setStudent_id(studentInfo.getStudent_id());
            history.setStudent_name(studentInfo.getStudent_name());
            historyJpa.save(history);
            history=new History();

        }
    }

    //实时更新功能。
    @Scheduled(fixedDelay = 120000) //两分钟更新一次。单位Ms
    public void NowStatus(){
        List<String> allInfo = allInfoJpa.findAllSensorId();
        List<String> cAllinfo = allInfo; //之前违纪学生
        List<String> list1 = dataJpa.getByBed(0);
        List<String> list2 = dataJpa.getByNoise(0);
        List<String> list3 = dataJpa.getByUsed(0);
        list1.addAll(list2);
        list1.addAll(list3);
        HashSet<String> hashSet = new HashSet<>(list1);
        List<String> list = new ArrayList<>(hashSet); //现在违纪学生
        List<String> cList = list;
        cList.removeAll(allInfo);//新增违纪学生；
        cAllinfo.removeAll(cList);//未违纪学生；
        for (String allinfoSensorId: cList
             ) {
            All_Info allInfoSensor = new All_Info();
            allInfoSensor.setSensor_id(allinfoSensorId);
            allInfoJpa.save(allInfoSensor);

        }
        for (String allinfoSensorId: cAllinfo
        ) {
            All_Info allInfoSensor = new All_Info();
            allInfoSensor.setSensor_id(allinfoSensorId);
            allInfoJpa.delete(allInfoSensor);
        }
        getCache.setAddInfo(list);
    }


}
