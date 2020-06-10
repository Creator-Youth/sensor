package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:01 下午
 *
 */

import com.example.demo.Dao.Money_History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyHistoryJpa extends JpaRepository<Money_History,Integer> {
}
