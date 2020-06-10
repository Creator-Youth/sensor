package com.example.demo.Controller;

import com.example.demo.Dao.Admin;
import com.example.demo.Services.Jpa.AdminJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "admin")
public class adminController {


    @Autowired
    AdminJpa adminJpa;


    @ResponseBody
    @GetMapping(value = "/getFlag")
    public boolean getFlag(@RequestParam("flag")boolean flag) {
        Admin admin =new Admin();
        adminJpa.save(admin);
        return Boolean.parseBoolean(null);
    }
}
