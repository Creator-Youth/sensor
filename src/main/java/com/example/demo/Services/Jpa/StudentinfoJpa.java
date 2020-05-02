package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:48 下午
 *
 */

import com.example.demo.Dao.Student_Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentinfoJpa extends JpaRepository<Student_Info,Integer> {
}
