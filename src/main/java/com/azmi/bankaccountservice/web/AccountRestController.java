package com.azmi.bankaccountservice.web;

import com.azmi.bankaccountservice.entities.BankAccount;
import com.azmi.bankaccountservice.enums.AccountType;
import com.azmi.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account with id %s not found", id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        if(bankAccount.getCreatedAt()==null) bankAccount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if (bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
