package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/5-9:10 下午
 *
 */

import com.example.demo.Dao.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorJpa extends JpaRepository<Sensor,Integer> {
    @Query("select sen from Sensor sen where sensor_name = ?1")
    Sensor getByName (String name);

}
