package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:32 下午
 *
 */

import com.example.demo.Dao.LoginInfo;
import com.example.demo.Services.Jpa.UserInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="login")
public class LoginController {

    @Autowired
    private UserInfoJpa userInfoJpa;

    @PostMapping("/login")
    @ResponseBody
    public LoginInfo getById(int id){
        return userInfoJpa.getOne(id);
    }


}
