package com.example.demo.Services.converse;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/11-9:27 下午
 *
 */

import com.example.demo.Dao.MySelfDao.DormitoryInfo;
import org.springframework.stereotype.Service;

@Service
public class StringToDormitory {

    public DormitoryInfo getDormitory(String str){
        String[] ss = str.split("-");
        DormitoryInfo dormitoryInfo = new DormitoryInfo();
        dormitoryInfo.setDormitortLou(ss[0]);
        String[] sss = ss[1].split("");
        dormitoryInfo.setDormitoryCeng(sss[0]);
        dormitoryInfo.setDormitorySushe(sss[1]+sss[2]);
        dormitoryInfo.setDormitoryChuang(ss[2]);
        return dormitoryInfo;
    }
}
