package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-5:07 下午
 *
 */

import com.example.demo.Dao.Dormitory;
import com.example.demo.Dao.MySelfDao.DormitoryLoucengDao;
import com.example.demo.Dao.MySelfDao.Dormitory_People;
import com.example.demo.Dao.MySelfDao.Dormitory_living;
import com.example.demo.Dao.MySelfDao.Dormitory_sushe;
import com.example.demo.Services.Jpa.AllInfoJpa;
import com.example.demo.Services.Jpa.DormitoryJpa;
import com.example.demo.Services.Jpa.StudentinfoJpa;
import com.example.demo.Services.PreStament.GetCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "countMessage")
public class CountMessage {
    @Autowired
    StudentinfoJpa studentinfoJpa;

    @Autowired
    GetCache getCache;

    @Autowired
    AllInfoJpa allInfoJpa;

    @Autowired
    DormitoryJpa dormitoryJpa;

    //获取大楼违纪信息
    @GetMapping(value = "/getLoucengInfo")
    @ResponseBody
    public List<DormitoryLoucengDao> getInfo(){
        List<DormitoryLoucengDao> result = new ArrayList<>();
        List<String> allInfoList = getCache.getAllInfo();
        List<Dormitory> dormitoryList = dormitoryJpa.findAll();
        for(Dormitory dormitory : dormitoryList ){
            DormitoryLoucengDao dormitoryLoucengDao = new DormitoryLoucengDao();
            dormitoryLoucengDao.setDormitory_louceng(dormitory.getDormitory_loucen());

            String selectDor = dormitory.getDormitory_loucen()+"-";
            List<String> list = studentinfoJpa.getInfoByLike(selectDor);
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

    //获取每层违纪信息
    @PostMapping(value = "/getSusheInfo")
    @ResponseBody
    public List<Dormitory_sushe> getSusheInfo(@RequestParam("dormitory") String dormitory){
        List<String> allInfoList = getCache.getAllInfo();
        List<Dormitory_sushe> result = new ArrayList<>();
        for(int i=1; i<=7;i++){
            Dormitory_sushe dormitory_sushe = new Dormitory_sushe();
            StringBuffer stringBuffer =new StringBuffer();
            stringBuffer.append(i);
            dormitory_sushe.setDormitory_sushe(stringBuffer.toString());

            stringBuffer =new StringBuffer();
            stringBuffer.append(dormitory);
            stringBuffer.append("-0");
            stringBuffer.append(i);
            List<String> list = studentinfoJpa.getInfoByLike(stringBuffer.toString());
            list.retainAll(allInfoList);
            if(!list.isEmpty()){
                dormitory_sushe.setFlag(true);
            }else {
                dormitory_sushe.setFlag(false);
            }
            result.add(dormitory_sushe);
        }
        return result;
    }


    //获取宿舍违纪信息
    @PostMapping(value = "/getLivingInfo")
    @ResponseBody
    public List<Dormitory_living> getLivingInfo(@RequestParam("dormitory") String dormitory,
                                                @RequestParam("dormitory_cen") String dormitory_cen){
        List<String> allInfoList = getCache.getAllInfo();
        List<Dormitory_living> result = new ArrayList<>();
        for(int i=1; i<=5;i++){
            Dormitory_living dormitoryLiving = new Dormitory_living();
            StringBuffer stringBuffer =new StringBuffer();
            stringBuffer.append(i);
            dormitoryLiving.setLiving(stringBuffer.toString());

            stringBuffer =new StringBuffer();
            stringBuffer.append(dormitory);
            stringBuffer.append("-0");
            stringBuffer.append(dormitory_cen);
            stringBuffer.append("0");
            stringBuffer.append(i);
            List<String> list = studentinfoJpa.getInfoByLike(stringBuffer.toString());
            list.retainAll(allInfoList);
            if(!list.isEmpty()){
                dormitoryLiving.setFlag(true);
            }else {
                dormitoryLiving.setFlag(false);
            }
            result.add(dormitoryLiving);
        }
        return result;
    }

    //获取宿舍违纪信息
    @PostMapping(value = "/getPeopleInfo")
    @ResponseBody
    public List<Dormitory_People> getLivingInfo(@RequestParam("dormitory") String dormitory,
                                                @RequestParam("dormitory_cen") String dormitory_cen
                                               ,@RequestParam("living") String living){
        List<String> allInfoList = getCache.getAllInfo();
        List<Dormitory_People> result = new ArrayList<>();
        for(int i=1; i<=6;i++){
            Dormitory_People dormitory_people = new Dormitory_People();
            StringBuffer stringBuffer =new StringBuffer();
            stringBuffer.append(i);
            dormitory_people.setDormitory_People(stringBuffer.toString());

            stringBuffer =new StringBuffer();
            stringBuffer.append(dormitory);
            stringBuffer.append("-0");
            stringBuffer.append(dormitory_cen);
            stringBuffer.append("0");
            stringBuffer.append(living);
            stringBuffer.append("-");
            stringBuffer.append(i);
            List<String> list = studentinfoJpa.getInfoByLike(stringBuffer.toString());
            list.retainAll(allInfoList);
            if(!list.isEmpty()){
                dormitory_people.setFlag(true);
            }else {
                dormitory_people.setFlag(false);
            }
            result.add(dormitory_people);
        }
        return result;
    }

}
