package com.example.demo.Controller;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-12:30 下午
 *
 */

import com.example.demo.Services.Jpa.BankCardBalanceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "balance")
public class balanceController {

    @Autowired
    BankCardBalanceJpa bankCardBalanceJpa;

    @ResponseBody
    @GetMapping(value = "/getBalance")
    public Double getBalance(@RequestParam("bankCard_id") String bankCard_id){
        return bankCardBalanceJpa.getBankCard_balancesByBankCard_id(bankCard_id);

    }
}
