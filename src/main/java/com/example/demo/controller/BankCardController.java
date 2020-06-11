package com.example.demo.controller;

import com.example.demo.dao.UserAccountJpa;
import com.example.demo.po.BankCard;
import com.example.demo.dao.BankCardJpa;
import com.example.demo.domain.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.demo.domain.ResultCode.USER_CARDPASSWORD_CARDPASSWORD;

@RestController
@RequestMapping(value = "bankCard")
public class BankCardController {
    @Autowired
    BankCardJpa bankCardJpa;

    @Autowired
    UserAccountJpa userAccountJpa;

    @ResponseBody
    @GetMapping(value = "/save")
    public ResResult saveBankCard(@RequestParam("bankCardPassword")String bankCardPassword,
                                  @RequestParam("userName")String userName) {
       /* ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String userName= session.getAttribute("USER").toString();*/

        int userId=userAccountJpa.getByUserName(userName).getId();
        if( bankCardPassword==null ){
            return ResResult.fail(USER_CARDPASSWORD_CARDPASSWORD);
        }else {
            BankCard bank_card = new BankCard();
            String bankCardNumber= com.example.demo.Utils.IDUtil.CardIdUtils.getCardId();
            bank_card.setBankCardNumber(bankCardNumber);
            bank_card.setBankCardPassword(bankCardPassword);
            bank_card.setBankCardBalance(0.0);
            bank_card.setCardFlag(false);
            bank_card.setUserId(userId);
            bankCardJpa.save(bank_card);
            ArrayList<String> bankCardNum = new ArrayList<>();
            bankCardNum.add(bankCardNumber);
            return ResResult.suc().setData(bankCardNum);
        }

    }

    //展示用户的所有账号信息
    @ResponseBody
    @GetMapping(value = "/showAllBankCard")
    public ResResult showAllBankCard(@RequestParam("userName")String userName){
        int userId=userAccountJpa.getByUserName(userName).getId();
        List<BankCard> bank_cardList= bankCardJpa.findBankCardByUserId(userId);
        return  ResResult.suc().setData(bank_cardList);
    }

    @ResponseBody
    @GetMapping (value = "/deleteBanKCard")
    public ResResult deleteBankCard(@RequestParam("bankCardNumber")String bankCardNumber){
        BankCard bank_card= bankCardJpa.getBankCardByBankCardNumber(bankCardNumber);
        if(bank_card.getBankCardBalance()==0) {
            bankCardJpa.delete(bank_card);
        }else{
            return  ResResult.fail(10005,"卡有余额");
        }
        return ResResult.suc();

    }
}
