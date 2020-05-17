package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:38 下午
 *
 */

import com.example.demo.Dao.Sensor;
import com.example.demo.Dao.Student_Info;
import com.example.demo.Services.Jpa.SensorJpa;
import com.example.demo.Services.Jpa.StudentinfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    SensorJpa sensorJpa;

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
                           @RequestParam("dormitory") String dormitory,
                           @RequestParam("sensor_id") String sensor_id
    ){
        if(null !=studentinfoJpa.getByStudentName(student_name)
                || null != studentinfoJpa.getByStudentId(student_id))
        {
            return "该学生已经存在";
        }
        Student_Info studentInfo = new Student_Info();
        studentInfo.setClass_name(class_name);
        studentInfo.setTeacher_name(teacher_name);
        studentInfo.setTeacher_id(teacher_id);
        studentInfo.setStudent_name(student_name);
        studentInfo.setSensor_id(sensor_id);
        studentInfo.setDormitory(dormitory);
        studentInfo.setStudent_id(student_id);
        try{
            studentinfoJpa.save(studentInfo);
        }catch (Exception e){
            return "添加失败，请检查数据";
        }
        return "添加成功";
    }

    //通过姓名查询学生信息
    @PostMapping(value = "/getInfoByname")
    @ResponseBody
    public  List<Student_Info> getInfoByName(@RequestParam("studentName") String  studentName){
        Student_Info studentInfo = null;
        List<Student_Info> list = new ArrayList<>();
        studentInfo = studentinfoJpa.getByStudentName(studentName);
        list.add(studentInfo);

        return list;
        //为空表示为查询到信息。
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
    @PostMapping(value = "/findStuInfo")
    @ResponseBody
    public List<Student_Info> findAll(@RequestParam("page") String page){
        Integer pageIndex = Integer.valueOf(page);
        Pageable pageable = PageRequest.of(pageIndex,20);
        Page<Student_Info> pagelist = studentinfoJpa.findAll(pageable);
        return pagelist.getContent();
    }

    @PostMapping(value = "/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("ID") String ID){
        int id = Integer.valueOf(ID);
        Student_Info studentInfo = studentinfoJpa.getOne(id);
        if(null == studentInfo){
            return "数据库异常，请联系王先首";
        }else{
            String sensor_id = studentInfo.getSensor_id();
            Sensor sensor = sensorJpa.getBySensorId(sensor_id);
            if(null==sensor){
                return "数据库异常，请联系王先首";
            }else {
                studentinfoJpa.delete(studentInfo);
                sensorJpa.delete(sensor);
                return "删除成功";
            }
        }

    }


}
