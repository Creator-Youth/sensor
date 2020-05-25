package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-10:38 下午
 *
 */

import com.example.demo.Dao.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryJpa extends JpaRepository<History,Integer> {

    @Query("select history from  History history where student_name=?1")
    List<History> getInfoByStudentName (String name);


    @Query("select history from  History history where time=?1")
    List<History> getInfoByTime (String time);
}
