package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-06-2020/6/10-5:33 下午
 *
 */

import com.example.demo.Dao.Card_History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardHistoryJpa extends JpaRepository<Card_History,Integer> {

}
