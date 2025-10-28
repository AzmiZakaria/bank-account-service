package com.azmi.bankaccountservice.entities;

import com.azmi.bankaccountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private String currency;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}