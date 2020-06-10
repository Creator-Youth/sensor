package com.example.demo.dao;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:33 下午
 *
 */

import com.example.demo.po.CardHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHistoryJpa extends JpaRepository<CardHistory,Integer> {

}
