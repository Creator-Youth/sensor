package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:47 下午
 *
 */

import com.example.demo.Dao.All_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AllInfoJpa extends JpaRepository<All_Info,Integer> {
    @Query("select allInfo from All_Info allInfo where sensor_id = ?1")
    All_Info getAllInfoById(String sensor_id);
}
