package com.example.demo.dao;


import com.example.demo.po.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCardJpa extends JpaRepository<BankCard, Integer> {

  /**
   * 通过银行卡号 查询银行卡实体
   *
   * @param bankCardNumber 银行卡号
   * @return {@link BankCard}实体
   */
  BankCard findByBankCardNumber(String bankCardNumber);
}
