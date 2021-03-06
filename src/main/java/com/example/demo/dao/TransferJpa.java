package com.example.demo.dao;

import com.example.demo.po.BankCardBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TransferJpa extends JpaRepository<BankCardBalance,Integer> {

	@Transactional
	@Modifying
	@Query("update BankCardBalance set money=money-?2 where bankCard_number=?1")
	public void out(String outer, Double money);

	@Transactional
	@Modifying
	@Query("update BankCardBalance set money=money+?2 where bankCard_number=?1")
	public void in(String inner, Double money);
}

