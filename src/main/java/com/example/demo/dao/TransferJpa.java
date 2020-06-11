package com.example.demo.dao;


import com.example.demo.po.BankCardBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferJpa extends JpaRepository<BankCardBalance,Integer> {

}
