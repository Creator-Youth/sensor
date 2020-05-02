package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:38 下午
 *
 */

import com.example.demo.Dao.Student_Info;
import com.example.demo.Services.Jpa.StudentinfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//
//处理学生信息接口
@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentinfoJpa studentinfoJpa;

    @RequestMapping(value = "/update")
    @ResponseBody
    //更新学生信息
    public int Update(@RequestBody Student_Info student_info){
        int id=0;
        return id;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    //添加学生信息
    public String saveInfo(@RequestBody Student_Info student_info){
        //studentinfoJpa.saveAndFlush(student_info)
        try{
            studentinfoJpa.save(student_info);
        }catch (Exception e){
            return "false";
        }
        return "true";
    }

    //查询学生信息
    @RequestMapping(value = "/getInfo")
    @ResponseBody
    public  List<Student_Info> getInfo(@RequestParam("student_id") String  student_id,
                                  @RequestParam("student_name") String  student_name,
                                  @RequestParam("class_name") String  class_name){
        //studentinfoJpa.saveAndFlush(student_info)
        Student_Info studentInfo = null;
        List<Student_Info> list = new ArrayList<>();
        if(student_id !=null && student_name==null&& class_name==null){
            studentInfo = studentinfoJpa.getByStudentId(student_id);
        }else if(student_id ==null && student_name!=null&& class_name==null){
            studentInfo = studentinfoJpa.getByStudentName(student_name);
        }else if(student_id ==null && student_name==null&& class_name!=null){
            list = studentinfoJpa.getByClassName(class_name);
        }else{
            return list;
        }

        if(null == studentInfo){
            return list;
        }else{
            list.add(studentInfo);
            return list;
        }
        //为空表示为查询到信息。
    }
}
