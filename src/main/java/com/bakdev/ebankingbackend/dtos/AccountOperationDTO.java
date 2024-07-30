package com.bakdev.ebankingbackend.dtos;

import com.bakdev.ebankingbackend.entities.BankAccount;
import com.bakdev.ebankingbackend.enums.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// Operations des comptes

@Data
public class AccountOperationDTO {

    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType operationType;
    private String description;

}
