package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:49 下午
 *
 */

import com.example.demo.Dao.Teacher_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherInfoJpa extends JpaRepository<Teacher_Info,Integer> {
    @Query("select tea from Teacher_Info tea where teacher_id = ?1")
    Teacher_Info getByTeacherId(String teacher_id);

    @Query("select tea from Teacher_Info tea where teacher_name = ?1")
    Teacher_Info getByTeacherName(String teacher_name);

}
