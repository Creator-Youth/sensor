package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/13-10:44 上午
 *
 */

import com.example.demo.Dao.History;
import com.example.demo.Dao.Student_Info;
import com.example.demo.Services.Jpa.HistoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="history")
public class HistoryController {

    @Autowired
    HistoryJpa historyJpa;

    @ResponseBody
    @GetMapping(value = "/findInfo")
    public List<History> findInfo(){
        Pageable pageable = PageRequest.of(0,10);
        Page<History> page = historyJpa.findAll(pageable);
        return page.getContent();
    }

    @ResponseBody
    @PostMapping(value = "/getInfoByName")
    public List<History> getInfoByName(@RequestParam("studentName") String Name){
        List<History> list = new ArrayList<>();
        return historyJpa.getInfoByStudentName(Name);
    }
}
