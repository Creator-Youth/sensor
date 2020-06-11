package com.example.demo.controller;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:28 下午
 *
 */

import static com.example.demo.domain.ResultCode.USER_FALSE_PASSWORD;
import static com.example.demo.domain.ResultCode.USER_NOT_EXIT;

import com.example.demo.po.UserAccount;
import com.example.demo.dao.UserAccountJpa;
import com.example.demo.domain.ResResult;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Random;

@RestController
@RequestMapping(value = "user")
public class AdminController {

    @Autowired
    UserAccountJpa userAccountJpa;

    @GetMapping(value = "/login")
    @ResponseBody
    public ResResult getPassword(@RequestParam("username")String userName, @RequestParam("userpassword")String password){
        UserAccount user_account = userAccountJpa.getByUserName(userName);
        if(null == user_account){
            return ResResult.fail(USER_NOT_EXIT);
        }else{
            if(!user_account.getUserPassword().equals(password)){
                return ResResult.fail(USER_FALSE_PASSWORD);
            }else{
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession();
                session.setAttribute("USER",userName);
                return ResResult.suc();
            }
        }
    }


    @GetMapping(value = "/RealName")
    @ResponseBody
    public ResResult realName(@RequestParam("username")String userName, @RequestParam("userpassword")String password){
        UserAccount user_account = userAccountJpa.getByUserName(userName);
        if(null == user_account){
            return ResResult.fail(USER_NOT_EXIT);
        }else{
            if(!user_account.getUserPassword().equals(password)){
                return ResResult.fail(USER_FALSE_PASSWORD);
            }else{
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession();
                session.setAttribute("USER",userName);
                return ResResult.suc();
            }
        }
    }

    @GetMapping(value = "/getCheckCode")
    @ResponseBody
    // 获取校验码
    public ResResult getCheckCode(){
        Integer checCode = (int)Math.random()*10000;
        StringBuffer stringBuffer = new StringBuffer();
        if(checCode <10){
            stringBuffer.append("000").append(checCode);
        }else if(10<=checCode && checCode<100){
            stringBuffer.append("00").append(checCode);
        }else if(100<=checCode && checCode<1000){
            stringBuffer.append("0").append(checCode);
        }else{
            stringBuffer.append(checCode);
        }

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.setAttribute("checkCode",stringBuffer.toString());
        return ResResult.suc().setData(checCode);
    }



}
