package com.example.demo.dao;

import com.example.demo.po.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpa extends JpaRepository<Admin,Integer> {
    

}
