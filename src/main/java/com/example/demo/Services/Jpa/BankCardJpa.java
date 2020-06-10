package com.example.demo.Services.Jpa;


import com.example.demo.Dao.Bank_Card;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCardJpa extends JpaRepository<Bank_Card,Integer>{
}
