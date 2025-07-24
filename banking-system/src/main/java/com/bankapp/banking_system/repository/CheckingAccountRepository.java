package com.bankapp.banking_system.repository;

import com.bankapp.banking_system.model.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<Checking, Long> {}
