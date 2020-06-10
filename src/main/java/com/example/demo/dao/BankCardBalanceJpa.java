package com.example.demo.dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-12:33 下午
 *
 */

import com.example.demo.po.BankCardBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankCardBalanceJpa extends JpaRepository<BankCardBalance, Integer> {

  @Query("select bankCard_balance.money from BankCardBalance bankCard_balance where bankCardId=?1")
  public Double getBankCard_balancesByBankCard_id(String bankCard_id);

  BankCardBalance findByBankCardId(String bankCard_id);
}
