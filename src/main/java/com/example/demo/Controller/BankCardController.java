package com.example.demo.Controller;

import com.example.demo.Dao.BankCard_balance;
import com.example.demo.Dao.Bank_Card;
import com.example.demo.Services.Jpa.BankCardBalanceJpa;
import com.example.demo.Services.Jpa.BankCardJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "bankCard")
public class BankCardController {
    @Autowired
    BankCardJpa bankCardJpa;

    @ResponseBody
    @GetMapping(value = "/getBankCard")
    public String getBankCard(@RequestParam("use_id") Integer use_id, @RequestParam("bankCard") String bankcard, @RequestParam("flag") Integer flag) {
        Bank_Card bank_card = new Bank_Card();
        bankCardJpa.save(bank_card);
        return null;
    }
}
