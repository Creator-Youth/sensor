package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-11:45 上午
 *
 */

import com.example.demo.Dao.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<Admin,Integer> {

}
