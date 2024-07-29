package com.bakdev.ebankingbackend.dtos;

import com.bakdev.ebankingbackend.entities.AccountOperation;
import com.bakdev.ebankingbackend.entities.Customer;
import com.bakdev.ebankingbackend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//Table Compte bancaire du client
@Data
public class CurrentBankAccountDTO extends BankAccountDTO{

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;


}
