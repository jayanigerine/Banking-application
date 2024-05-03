package com.example.demo.repository;

import com.example.demo.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance,Integer> {

}
