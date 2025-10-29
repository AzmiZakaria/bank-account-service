package com.azmi.bankaccountservice.repositories;

import com.azmi.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankAccountRepository  extends JpaRepository<BankAccount, String> {
}
