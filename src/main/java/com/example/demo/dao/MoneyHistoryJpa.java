package com.example.demo.dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:01 下午
 *
 */

import com.example.demo.po.MoneyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyHistoryJpa extends JpaRepository<MoneyHistory, Integer> {
}



