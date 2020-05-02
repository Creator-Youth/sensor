package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:47 下午
 *
 */

import com.example.demo.Dao.All_Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllInfoJpa extends JpaRepository<All_Info,Integer> {
}
