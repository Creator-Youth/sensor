package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:48 下午
 *
 */

import com.example.demo.Dao.All_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorInfoJpa extends JpaRepository<All_Info,Integer> {

}
