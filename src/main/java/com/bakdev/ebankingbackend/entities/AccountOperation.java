package com.bakdev.ebankingbackend.entities;

import com.bakdev.ebankingbackend.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// Operations des comptes
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType operationType;
    private String description;

    @ManyToOne
    private BankAccount bankAccount ; // une opération concerne un compte
}
