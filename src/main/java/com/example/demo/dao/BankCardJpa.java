package com.example.demo.dao;


import com.example.demo.po.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface BankCardJpa extends JpaRepository<BankCard, Integer> {

  /**
   * 通过银行卡号 查询银行卡实体
   *
   * @param bankCardNumber 银行卡号
   * @return {@link BankCard}实体
   */


  @Query("SELECT bankCard FROM BankCard bankCard where bankCardNumber=?1")
  public BankCard getBankCardByBankCardNumber(String bankCardNumber);

  @Query("SELECT bankCard FROM BankCard bankCard where userId=?1")
  List<BankCard> findBankCardByUserId(Integer userId);
}
