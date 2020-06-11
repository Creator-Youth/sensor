package com.example.demo.Utils.IDUtil;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-9:37 下午
 *
 */

public class CardId {
    public  synchronized String getCardId(){
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("666666");
        StringBuffer tempString = new StringBuffer();
        Long t1 = System.currentTimeMillis();
       tempString.append(t1.toString());
        tempString.reverse();
        stringBuffer.append(tempString.toString().substring(1));
        return stringBuffer.toString();
    }
}
