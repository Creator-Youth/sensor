package com.example.demo.controller;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:28 下午
 *
 */

import com.example.demo.Utils.IDUtil.UserIdUtils;
import com.example.demo.dao.UserAccountJpa;
import com.example.demo.dao.UserInfoJpa;
import com.example.demo.domain.ResResult;
import com.example.demo.exception.BizException;
import com.example.demo.po.UserAccount;
import com.example.demo.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

import static com.example.demo.domain.ResultCode.USER_FALSE_PASSWORD;
import static com.example.demo.domain.ResultCode.USER_NOT_EXIT;
import static com.example.demo.exception.CommonException.ID_CARD_Error;

@RestController
@RequestMapping(value = "user")
public class AdminController {

    @Autowired
    UserAccountJpa userAccountJpa;

    @Autowired
    UserInfoJpa userInfoJpa;

    @GetMapping(value = "/login")
    @ResponseBody
    //用户登录
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
    //实名认证
    public ResResult realName(@RequestParam("realname")String realName,
                              @RequestParam("realid")String realId,
                              @RequestParam("realaddress")String realaddress,
                              @RequestParam("realphone")String realPhone){
       UserInfo userInfo = new UserInfo();
       userInfo.setUserIdCard(realId);
       try{
           userInfoJpa.save(userInfo);
       }catch (Exception e){
           //"1001","身份证号有误或已实名认证"
           throw new BizException(ID_CARD_Error);
       }
       userInfo.setUserAddress(realaddress);
       userInfo.setUserTel(realPhone);
       userInfo.setUserRealName(realName);
       String userID = UserIdUtils.creatUserID(realId);
       userInfoJpa.save(userInfo);
       return ResResult.suc();

    }

    @ResponseBody
    @GetMapping(value = "/getCheckCode")

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

    @ResponseBody
    @PostMapping (value = "/creatAccount")

    // 获取校验码
    //账号，密码
    public ResResult creatAccount(@RequestParam("username")String userName,
                                  @RequestParam("Inputpassword")String password){

        UserAccount userAccount= new UserAccount();
        userAccount.setUserName(userName);
        try{
            userAccountJpa.save(userAccount);
        }catch (Exception e){
            throw new BizException("10004","账号已存在");
        }
        userAccount.setUserPassword(password);
        userAccountJpa.save(userAccount);
        return ResResult.suc();
    }


}
