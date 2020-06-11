package com.example.demo.controller;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-12:30 下午
 *
 */

import com.example.demo.services.ChangeBalanceService;
import com.example.demo.dao.BankCardBalanceJpa;
import com.example.demo.utils.ObjectUtils;
import com.example.demo.domain.ResResult;
import com.example.demo.vo.ChangeBalanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "balance")
public class BalanceController {

    @Autowired
    private  BankCardBalanceJpa bankCardBalanceJpa;

    @Autowired
    private  ChangeBalanceService changeBalanceService;


    @ResponseBody
    @GetMapping(value = "/getBalance")
    //查余额
    public ResResult getBalance(@RequestParam("bankCard_id") String bankCard_id) {
        Double balance = bankCardBalanceJpa.getBankCard_balancesByBankCard_id(bankCard_id);
        return ResResult.suc().setData(balance);
    }

    /**
     * 取款
     *
     * @return
     */
    @PostMapping("/withdrawMoney")
    public ResResult<Double> withdrawMoney(@RequestBody ChangeBalanceView changeBalanceView) {
        return new ResResult<Double>().setData(
                this.changeBalanceService.withdrawMoney(
                        ObjectUtils.requireNonNull(changeBalanceView, "取钱不能为空")));
    }

    /**
     * 存款
     *
     * @return
     */
    @PostMapping("/depositMoney")
    public ResResult<Double> depositMoney(@RequestBody ChangeBalanceView changeBalanceView) {
        return new ResResult<Double>().setData(
                this.changeBalanceService.depositMoney(
                        ObjectUtils.requireNonNull(changeBalanceView, "取钱不能为空")));
    }
}
