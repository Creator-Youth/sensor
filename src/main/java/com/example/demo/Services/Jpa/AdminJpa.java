package com.example.demo.Services.Jpa;

import com.example.demo.Dao.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJpa extends JpaRepository<Admin,Integer> {
    

}
