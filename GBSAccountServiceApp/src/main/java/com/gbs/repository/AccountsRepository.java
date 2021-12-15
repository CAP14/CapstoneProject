package com.gbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbs.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, String> {

}
