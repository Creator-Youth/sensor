package com.example.demo.Services.saveHistory;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:26 下午
 *
 */

import com.example.demo.Dao.Card_History;
import com.example.demo.Dao.Money_History;
import com.example.demo.Services.Jpa.CardHistoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CardHistory {

    final static String  ADD_CARD = "addCard";

    final static String  DEV_CARD = "devCard";

    @Autowired
    CardHistoryJpa cardHistoryJpa;

    //开卡记录
    public void addBankId(String bankID){
        String formatString = "yyyy/MM/dd hh:mm.ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

        Date date = Calendar.getInstance().getTime();
        String formattedDate = simpleDateFormat.format(date);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String user = session.getAttribute("USER").toString();
        Card_History cardHistory = new Card_History();
        cardHistory.setAction(ADD_CARD);
        cardHistory.setBankID(bankID);
        cardHistory.setUser(user);
        cardHistory.setData(formattedDate);
        cardHistoryJpa.save(cardHistory);
    }

    public void devBankId(String bankID){
        String formatString = "yyyy/MM/dd hh:mm.ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

        Date date = Calendar.getInstance().getTime();
        String formattedDate = simpleDateFormat.format(date);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String user = session.getAttribute("USER").toString();
        Card_History cardHistory = new Card_History();
        cardHistory.setAction(DEV_CARD);
        cardHistory.setBankID(bankID);
        cardHistory.setUser(user);
        cardHistory.setData(formattedDate);
        cardHistoryJpa.save(cardHistory);
    }



}
