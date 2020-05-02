package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:49 下午
 *
 */

import com.example.demo.Dao.Teacher_Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherInfoJpa extends JpaRepository<Teacher_Info,Integer> {
}
