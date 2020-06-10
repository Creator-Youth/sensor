package com.example.demo.controller;

import com.example.demo.po.BankCard;
import com.example.demo.dao.BankCardJpa;
import com.example.demo.domain.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bankCard")
public class BankCardController {
    @Autowired
    BankCardJpa bankCardJpa;

    @ResponseBody
    @GetMapping(value = "/getBankCard")
    public ResResult getBankCard(@RequestParam("use_id") Integer use_id, @RequestParam("bankCard") String bankcard, @RequestParam("flag") Integer flag) {
        BankCard bankCard = new BankCard();
        bankCardJpa.save(bankCard);
        return ResResult.suc();
    }
}
