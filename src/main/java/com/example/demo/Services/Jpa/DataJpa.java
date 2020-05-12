package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:45 下午
 *
 */

import com.example.demo.Dao.Data;
import com.example.demo.Dao.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataJpa extends JpaRepository<Data,Integer> {
    @Query("select data from Data data where sensor_id = ?1")
    Data getDataBySensorID(String sensorId);

    @Query("select data.sensor_id from Data data where have_noise=?1")
    List<String>  getByNoise(int have_noise);

    @Query("select data.sensor_id from Data data where have_inbed=?1")
    List<String>  getByBed(int have_inbed);

    @Query("select data.sensor_id from Data data where have_used=?1")
    List<String>  getByUsed(int have_used);

    @Query("select data.sensor_id from Data data")
    List<String> findAllSensorId ();
}
