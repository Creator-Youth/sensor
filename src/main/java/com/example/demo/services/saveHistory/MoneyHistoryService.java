package com.example.demo.services.saveHistory;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-4:30 下午
 *
 */

import com.example.demo.dao.MoneyHistoryJpa;
import com.example.demo.po.MoneyHistory;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MoneyHistoryService {

  final static String ADD_MONLY = "addMoney";

  final static String DEV_MONLY = "devMoney";

  private final MoneyHistoryJpa moneyHistoryJpa;

  public MoneyHistoryService(MoneyHistoryJpa moneyHistoryJpa) {
    this.moneyHistoryJpa = moneyHistoryJpa;
  }

  //存款记录
  public void saveAddMoney(String money, String bankID) {
    String formatString = "yyyy/MM/dd hh:mm.ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

    Date date = Calendar.getInstance().getTime();
    String formattedDate = simpleDateFormat.format(date);
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes();
    HttpSession session = attr.getRequest().getSession();
    String user = session.getAttribute("USER").toString();
    MoneyHistory moneyHistory = new MoneyHistory();
    moneyHistory.setUser(user);
    moneyHistory.setData(formattedDate);
    moneyHistory.setMoney(money);
    moneyHistory.setBankId(bankID);
    moneyHistory.setAction(ADD_MONLY);
    moneyHistoryJpa.save(moneyHistory);
  }

  //取款记录
  public void saveDevMoney(String money, String bankID) {
    String formatString = "yyyy/MM/dd hh:mm.ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

    Date date = Calendar.getInstance().getTime();
    String formattedDate = simpleDateFormat.format(date);
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
        .currentRequestAttributes();
    HttpSession session = attr.getRequest().getSession();
    String user = session.getAttribute("USER").toString();
    MoneyHistory moneyHistory = new MoneyHistory();
    moneyHistory.setUser(user);
    moneyHistory.setData(formattedDate);
    moneyHistory.setMoney(money);
    moneyHistory.setBankId(bankID);
    moneyHistory.setAction(DEV_MONLY);
    moneyHistoryJpa.save(moneyHistory);
  }

}
