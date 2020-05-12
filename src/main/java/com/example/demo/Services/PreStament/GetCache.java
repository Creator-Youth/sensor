package com.example.demo.Services.PreStament;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/12-8:44 下午
 *
 */

import com.example.demo.Services.Jpa.AllInfoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class GetCache {
    @Autowired
    AllInfoJpa allInfoJpa;

    private HashMap<String, List> hashMap =new HashMap<>();

    public List<String> getAllInfo(){
        if (hashMap.get("allInfo")==null) {
            List<String> list = allInfoJpa.findAllSensorId();
            hashMap.put("allInfo",list);
        }
        return hashMap.get("allInfo");
    }
}
