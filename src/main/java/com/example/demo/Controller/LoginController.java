package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:32 下午
 *
 */

import com.example.demo.Dao.*;
import com.example.demo.Services.Jpa.*;
import com.example.demo.Services.PreStament.GetCache;
import com.example.demo.Services.PreStament.preJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    HistoryJpa historyJpa;
    @Autowired
    GetCache getCache;

    @Autowired
    DormitoryJpa dormitoryJpa;

    @Autowired
    preJob prejob;

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
    @Autowired
    private LoginInfoJpa loginInfoJpa;

    @Autowired
    preJob pre;

    @PostMapping(value = "/getAllById")
    @ResponseBody
    public LoginInfo getById(int id){
        return loginInfoJpa.getOne(id);
    }


    /*验证登录接口*/
    @PostMapping(value = "/getPasswordByusername")
    @ResponseBody
    public Boolean getPasswordByUsername(@RequestParam("user_name") String user_name, @RequestParam("password") String password){

       /*prejob.preData();
         prejob.preforSensor();
         prejob.preStudentInfo();
        if(allInfoJpa.count()<1){
            preLogin();
        }*/
        /*Dormitory dormitory = new Dormitory();
          for(int i =1;i<=20;i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            dormitory.setDormitory_loucen(stringBuffer.toString());
            dormitoryJpa.save(dormitory);
            dormitory=new Dormitory();

        }*/
        //postSignOut();
        LoginInfo loginInfo = loginInfoJpa.findbyUsername(user_name);
        if(null == loginInfo){
            return false;
        }
        if(loginInfo.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

   @GetMapping(value = "/loginOut")
   @ResponseBody
   public void loginOut(){
        pre.postSignOut();
   }
}
