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


}
