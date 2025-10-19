package com.azmi.bankaccountservice;

import com.azmi.bankaccountservice.entities.BankAccount;
import com.azmi.bankaccountservice.enums.AccountType;
import com.azmi.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository) {
        return args -> {
          for(int i=1;i<10;i++){
              BankAccount bankAccount = BankAccount.builder()
                      .id(UUID.randomUUID().toString())
                      .balance(1000+Math.random()*9000)
                      .currency("MAD")
                      .createdAt(new Date())
                      .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                      .build();
              bankAccountRepository.save(bankAccount);
          }
        };
    }

}
