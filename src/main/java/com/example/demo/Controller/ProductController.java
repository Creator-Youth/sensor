package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-04-2020/4/22-7:29 下午
 *
 */

import com.example.demo.Dao.Teacher_Info;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "teacher")
//处理老师接口
public class ProductController {

    @PostMapping(value = "/update")
    @ResponseBody
    //更新老师联系方式
    public int  Update(@RequestBody  Teacher_Info teacher_info){
        int id=0;
        return id;
    }

}
