package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:28 下午
 *
 */

import com.example.demo.Dao.User_Account;
import com.example.demo.Services.Jpa.UserAccountJpa;
import com.example.demo.Utils.Data.ResResult;
import com.example.demo.Utils.Data.ResultCode;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.Utils.Data.ResultCode.USER_FALSE_PASSWORD;
import static com.example.demo.Utils.Data.ResultCode.USER_NOT_EXIT;

@RestController
@RequestMapping(value = "admin")
public class Admin {

    @Autowired
    UserAccountJpa userAccountJpa;

    @GetMapping(value = "getPassword")
    @ResponseBody
    public ResResult getPassword(@RequestParam("userName")String userName, @RequestParam("password")String password){
        User_Account user_account = userAccountJpa.getByUserName(userName);
        if(null == user_account){
            return ResResult.fail(USER_NOT_EXIT);
        }else{
            if(user_account.getUser_password()!=password){
                return ResResult.fail(USER_FALSE_PASSWORD);
            }else{
                return ResResult.suc();
            }
        }
    }
}
