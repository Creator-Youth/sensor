package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-5:07 下午
 *
 */

import com.example.demo.Dao.Dormitory;
import com.example.demo.Dao.MySelfDao.DormitoryLoucengDao;
import com.example.demo.Services.Jpa.AllInfoJpa;
import com.example.demo.Services.Jpa.DormitoryJpa;
import com.example.demo.Services.Jpa.StudentinfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "countMessage")
public class CountMessage {
    @Autowired
    StudentinfoJpa studentinfoJpa;

    @Autowired
    AllInfoJpa allInfoJpa;

    @Autowired
    DormitoryJpa dormitoryJpa;

    @GetMapping(value = "/getLoucengInfo")
    @ResponseBody
    public List<DormitoryLoucengDao> getInfo(){
        List<DormitoryLoucengDao> result = new ArrayList<>();
        List<String> allInfoList = allInfoJpa.findAllSensorId();
        List<Dormitory> dormitoryList = dormitoryJpa.findAll();
        for(Dormitory dormitory : dormitoryList ){
            DormitoryLoucengDao dormitoryLoucengDao = new DormitoryLoucengDao();
            dormitoryLoucengDao.setDormitory_louceng(dormitory.getDormitory_loucen());

            String selectDor = dormitory.getDormitory_loucen()+"-";
            List<String> list = studentinfoJpa.getByDormitoryCen(selectDor);
            String ss ="";
            list.retainAll(allInfoList);
            if(!list.isEmpty()){
               dormitoryLoucengDao.setFlag(true);
            }else {
                dormitoryLoucengDao.setFlag(false);
            }
            result.add(dormitoryLoucengDao);

        }
        return result;
    }
}
