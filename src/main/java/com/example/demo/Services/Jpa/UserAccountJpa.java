package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-2:30 下午
 *
 */

import com.example.demo.Dao.User_Account;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAccountJpa extends JpaRepository<User_Account,Integer> {
    @Query("Select userAccount from User_Account userAccount where user_name=?1")
    public User_Account getByUserName(String user_name);
}
