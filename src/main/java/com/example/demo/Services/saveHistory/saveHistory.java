package com.example.demo.Services.saveHistory;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-4:30 下午
 *
 */

import com.example.demo.Dao.Money_History;
import com.example.demo.Services.Jpa.MoneyHistoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class saveHistory {

    final static String  ADD_MONLY = "addMoney";

    final static String  DEV_MONLY = "devMoney";

    @Autowired
    MoneyHistoryJpa moneyHistoryJpa;

    //存款记录
    public void saveAddMoney(String money , String bankID){
        String formatString = "yyyy/MM/dd hh:mm.ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

        Date date = Calendar.getInstance().getTime();
        String formattedDate = simpleDateFormat.format(date);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String user = session.getAttribute("USER").toString();
        Money_History moneyHistory = new Money_History();
        moneyHistory.setUser(user);
        moneyHistory.setData(formattedDate);
        moneyHistory.setMoney(money);
        moneyHistory.setBankID(bankID);
        moneyHistory.setAction(ADD_MONLY);
        moneyHistoryJpa.save(moneyHistory);
    }

    //取款记录
    public void saveDevMoney(String money , String bankID){
        String formatString = "yyyy/MM/dd hh:mm.ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

        Date date = Calendar.getInstance().getTime();
        String formattedDate = simpleDateFormat.format(date);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String user = session.getAttribute("USER").toString();
        Money_History moneyHistory = new Money_History();
        moneyHistory.setUser(user);
        moneyHistory.setData(formattedDate);
        moneyHistory.setMoney(money);
        moneyHistory.setBankID(bankID);
        moneyHistory.setAction(DEV_MONLY);
        moneyHistoryJpa.save(moneyHistory);
    }

}
