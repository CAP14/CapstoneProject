package com.gbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbs.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

}
