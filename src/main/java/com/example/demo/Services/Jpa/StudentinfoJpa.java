package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:48 下午
 *
 */

import com.example.demo.Dao.Student_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentinfoJpa extends JpaRepository<Student_Info,Integer> {

    //通过学号查询
    @Query("select stu from Student_Info stu where student_id= ?1")
    Student_Info getByStudentId(String student_id);

    @Query("select stu from Student_Info stu where student_name= ?1")
    Student_Info getByStudentName(String student_name);

    @Query("select stu from Student_Info stu where class_name= ?1")
    List<Student_Info> getByClassName(String class_name);

    @Query("select stu from Student_Info stu where sensor_id= ?1")
    Student_Info getBySensorName(String sensor_id);

}
