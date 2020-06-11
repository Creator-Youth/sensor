package com.example.demo.dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/11-9:19 上午
 *
 */

import com.example.demo.po.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoJpa extends JpaRepository<UserInfo,Integer> {
}
