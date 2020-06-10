package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:28 下午
 *
 */

import com.example.demo.Dao.User_Account;
import com.example.demo.Services.Jpa.UserAccountJpa;
import com.example.demo.Utils.Data.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.Utils.Data.ResultCode.USER_FALSE_PASSWORD;
import static com.example.demo.Utils.Data.ResultCode.USER_NOT_EXIT;

@RestController
@RequestMapping(value = "user")
public class Admin {

    @Autowired
    UserAccountJpa userAccountJpa;

    @GetMapping(value = "/login")
    @ResponseBody
    public ResResult getPassword(@RequestParam("username")String userName, @RequestParam("userpassword")String password){
        User_Account user_account = userAccountJpa.getByUserName(userName);
        if(null == user_account){
            return ResResult.fail(USER_NOT_EXIT);
        }else{
            if(!user_account.getUser_password().equals(password)){
                return ResResult.fail(USER_FALSE_PASSWORD);
            }else{
                return ResResult.suc();
            }
        }
    }
}