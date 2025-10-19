package com.azmi.bankaccountservice.repositories;

import com.azmi.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccount, String> {
}
