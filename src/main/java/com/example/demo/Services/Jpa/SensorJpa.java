package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/5-9:10 下午
 *
 */

import com.example.demo.Dao.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorJpa extends JpaRepository<Sensor,Integer> {
    @Query("select sen from Sensor sen where sensor_id = ?1")
    Sensor getBySensorId (String sensorId);

    @Query("select sen.sensor_id from Sensor sen")
    List<String> findAllSensorId ();

}
