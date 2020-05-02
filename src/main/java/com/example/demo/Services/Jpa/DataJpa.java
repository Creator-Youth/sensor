package com.example.demo.Services.Jpa;/*
 *  @author huajishaonian
 *  time : 2020-05-2020/5/2-6:45 下午
 *
 */

import com.example.demo.Dao.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpa extends JpaRepository<Data,Integer> {
}
