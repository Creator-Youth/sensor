package com.example.demo.dao;


import com.example.demo.po.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCardJpa extends JpaRepository<BankCard,Integer>{

  BankCard findByBankCardNumber(String bankCard_number);
}
