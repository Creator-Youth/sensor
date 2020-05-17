package com.example.demo.Services.PreStament;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/17-9:16 下午
 *
 */

import com.example.demo.Services.Jpa.AllInfoJpa;
import com.example.demo.Services.Jpa.BadSensorInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//本部分用于设计定时任务,用于数据更新功能；
/*@EnableScheduling
public class TimeWork {
    @Autowired
    preJob pre;

    @Autowired
    AllInfoJpa allInfoJpa;

    @Autowired
    BadSensorInfoJpa badSensorInfoJpa;

    @Scheduled(cron="0 10 10 ? * *")//秒、分、时、日期、月份、星期、年份（可省略）
    //更新数据库违纪信息（设置每天十点十分执行）
    public void prePareWork(){
        saveHistory();
    }

    @Scheduled(fixedDelay = 3600000)//每小时执行一次
    public void saveHistory(){
        allInfoJpa.deleteAll();
        badSensorInfoJpa.deleteAll();
        pre.preLogin();
        pre.postSignOut();
    }


}*/
