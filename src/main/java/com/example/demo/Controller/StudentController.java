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

    @PostMapping (value = "/save")
    @ResponseBody
    //添加学生信息
    public String saveInfo(@RequestParam("student_id") String  student_id,
                           @RequestParam("student_name") String  student_name,
                           @RequestParam("class_name") String  class_name,
                                       @RequestParam("teacher_id") String  teacher_id,
                                       @RequestParam("teacher_name") String  teacher_name,
                           @RequestParam("dormitory") String doymitory
    ){
        Student_Info studentInfo = new Student_Info();
        studentInfo.setTeacher_name(teacher_name);
        try{
            studentinfoJpa.save(studentInfo);
        }catch (Exception e){
            return "false";
        }
        return "true";
    }

    //查询学生信息
    @PostMapping(value = "/getInfo")
    @ResponseBody
    public  List<Student_Info> getInfo(@RequestParam("student_id") String  student_id,
                                  @RequestParam("student_name") String  student_name,
                                  @RequestParam("class_name") String  class_name){
        Student_Info studentInfo = null;
        List<Student_Info> list = new ArrayList<>();
        List<Student_Info> result = list;
        studentInfo = studentinfoJpa.getByStudentId(student_id);
        if(null != studentInfo){list.add(studentInfo);}

        studentInfo = studentinfoJpa.getByStudentName(student_name);
        if(null != studentInfo){list.add(studentInfo);}

        result = studentinfoJpa.getByClassName(class_name);
        for (Student_Info stu:result
             ) {
            list.add(stu);
        }
        return list;
        //为空表示为查询到信息。
    }

    //查询所有学生信息
    @GetMapping(value = "findAll")
    @ResponseBody
    public List<Student_Info> findAll(){
        return studentinfoJpa.findAll();
    }
}
