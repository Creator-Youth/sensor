package com.example.demo.dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:30 下午
 *
 */

import com.example.demo.po.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAccountJpa extends JpaRepository<UserAccount,Integer> {
    @Query("Select userAccount from UserAccount userAccount where userName=?1")
    public UserAccount getByUserName(String userName);
}
