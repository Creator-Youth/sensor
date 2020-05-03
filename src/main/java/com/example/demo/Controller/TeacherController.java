package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/3-9:18 下午
 *
 */

import com.example.demo.Dao.Teacher_Info;
import com.example.demo.Services.Jpa.TeacherInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {
    @Autowired
    TeacherInfoJpa teacherInfoJpa;

    //查询接口
    @PostMapping(value = "select")
    @ResponseBody
    public List<Teacher_Info> getInfoBy(@RequestParam("teacherId") String teacherId,@RequestParam("teacherName") String teacherName){
        List<Teacher_Info> list = new ArrayList<>();
        Teacher_Info teacherInfo = null;
        teacherInfo = teacherInfoJpa.getByTeacherId(teacherId);
        if(null !=teacherInfo){list.add(teacherInfo);teacherInfo=null;}
        teacherInfo = teacherInfoJpa.getByTeacherName(teacherName);
        if(null !=teacherInfo){list.add(teacherInfo);teacherInfo=null;}
        return list;
    }

    @GetMapping(value = "findAll")
    @ResponseBody
    public List<Teacher_Info> findAll(){
        return teacherInfoJpa.findAll();
    }
}