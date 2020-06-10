package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-12:33 下午
 *
 */

import com.example.demo.Dao.BankCard_balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankCardBalanceJpa extends JpaRepository<BankCard_balance, Integer> {

  @Query("select bankCard_balance.money from BankCard_balance bankCard_balance where bankCard_id=?1")
  public Double getBankCard_balancesByBankCard_id(String bankCard_id);

  BankCard_balance findByBankCard_id(String bankCard_id);
}
