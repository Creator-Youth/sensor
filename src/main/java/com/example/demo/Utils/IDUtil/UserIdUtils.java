package com.example.demo.Utils.IDUtil;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/11-9:03 上午
 *
 */

import org.springframework.stereotype.Service;

@Service
public class UserIdUtils {

    /*
        输入身份证号，生成用户ID    */
    public static String creatUserID(String IDCard) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CITIC");
        stringBuffer.append(IDCard);
        return stringBuffer.toString();
    }
}
