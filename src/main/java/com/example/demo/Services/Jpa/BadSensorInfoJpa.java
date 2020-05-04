package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/4-8:28 下午
 *
 */

import com.example.demo.Dao.BadSensor_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BadSensorInfoJpa extends JpaRepository<BadSensor_Info, Integer> {
    @Query("select badInfo from BadSensor_Info badInfo where sensor_id = ?1")
    BadSensor_Info getById(String sensor_id);
}
