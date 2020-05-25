package com.example.demo.Services.PreStament;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/20-1:19 下午
 *
 */

import com.example.demo.Dao.History;
import com.example.demo.Dao.Student_Info;
import com.example.demo.Services.Jpa.HistoryJpa;
import com.example.demo.Services.Jpa.StudentinfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class threadHistory implements Runnable {

    @Override
    public void run() {

    }

    //@Autowired
    /*HistoryJpa historyJpa;

    @Autowired
    StudentinfoJpa studentinfoJpa;
    @Override
    public void run() {
        int i=1;
        while(i<=4){
            saveHistory();

        }
    }

    public void saveHistory(){
        Calendar cal = Calendar.getInstance();
        Date data = cal.getTime();
        String DEFAULT_PATTERN ="yyyy-MM-dd-hh"; //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        String time = sdf.format(data);
        History history = new History();
        List<String> list = getCache.getAllInfo();
        for(String sensor_id:list){
            Student_Info studentInfo = studentinfoJpa.getBySensorName(sensor_id);
            history.setTime(time);
            history.setStudent_id(studentInfo.getStudent_id());
            history.setStudent_name(studentInfo.getStudent_name());
            historyJpa.save(history);
            history=new History();

        }
    }*/

}
