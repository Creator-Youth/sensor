package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-2:02 下午
 *
 */

import com.example.demo.Dao.Dormitory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DormitoryJpa extends JpaRepository<Dormitory,Integer> {
}
