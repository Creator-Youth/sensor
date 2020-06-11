package com.example.demo.services.saveHistory;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:26 下午
 *
 */

import com.example.demo.dao.CardHistoryJpa;
import com.example.demo.po.CardHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CardHistoryService {

    //申请卡
    final static String  ADD_CARD = "addCard";
    //注销卡
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
        CardHistory cardHistory =new CardHistory();
        cardHistory.setAction(ADD_CARD);
        cardHistory.setBankId(bankID);
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
        CardHistory cardHistory =new CardHistory();
        cardHistory.setAction(DEV_CARD);
        cardHistory.setBankId(bankID);
        cardHistory.setUser(user);
        cardHistory.setData(formattedDate);
        cardHistoryJpa.save(cardHistory);
    }



}
