package com.example.demo.dao;

import com.example.demo.po.BankCardBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InOutJpa extends JpaRepository<BankCardBalance,Integer> {
	@Query("update BankCardBalance set money=money-?2 where bankCard_number=?1")
	public void out(String outer, Double money);
	@Query("update BankCardBalance set money=money+?2 where bankCard_number=?1")
	public void in(String inner, Double money);
}

