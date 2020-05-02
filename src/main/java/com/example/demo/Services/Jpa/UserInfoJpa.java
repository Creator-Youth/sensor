package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/18-9:18 下午
 *
 */

import com.example.demo.Dao.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoJpa extends JpaRepository<LoginInfo,Integer> {

    @Query("select loginInfo from LoginInfo loginInfo where user_name= ?1")
    LoginInfo findbyUsername(String user_name);
}
