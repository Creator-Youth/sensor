package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:32 下午
 *
 */

import com.example.demo.Dao.LoginInfo;
import com.example.demo.Services.Jpa.UserInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private UserInfoJpa userInfoJpa;

    @PostMapping(value = "/getAllById")
    @ResponseBody
    public LoginInfo getById(int id){
        return userInfoJpa.getOne(id);
    }


    /*验证登录接口*/
    @PostMapping(value = "/getPasswordByusername")
    @ResponseBody
    public Boolean getPasswordByUsername(@RequestParam("user_name") String user_name, @RequestParam("password") String password){
        Boolean judge = true;
        System.out.println(user_name);
        System.out.println(password);
        LoginInfo loginInfo = userInfoJpa.findbyUsername(user_name);
        if(loginInfo == null || loginInfo.getPassword() !=password){
            judge=false;
        }
        return judge;
    }
}
