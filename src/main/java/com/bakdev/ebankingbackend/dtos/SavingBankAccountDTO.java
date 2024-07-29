package com.bakdev.ebankingbackend.dtos;

import com.bakdev.ebankingbackend.enums.AccountStatus;
import lombok.Data;

import java.util.Date;

//Table Compte bancaire du client
@Data
public class SavingBankAccountDTO extends BankAccountDTO{

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;


}
