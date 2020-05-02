package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:32 下午
 *
 */

import com.example.demo.Dao.LoginInfo;
import com.example.demo.Services.Jpa.LoginInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private LoginInfoJpa loginInfoJpa;

    @PostMapping(value = "/getAllById")
    @ResponseBody
    public LoginInfo getById(int id){
        return loginInfoJpa.getOne(id);
    }


    /*验证登录接口*/
    @PostMapping(value = "/getPasswordByusername")
    @ResponseBody
    public Boolean getPasswordByUsername(@RequestParam("user_name") String user_name, @RequestParam("password") String password){
        Boolean judge = true;
        System.out.println(user_name);
        System.out.println(password);
        LoginInfo loginInfo = loginInfoJpa.findbyUsername(user_name);
        if(loginInfo == null || loginInfo.getPassword() !=password){
            judge=false;
        }
        return judge;
    }
}
