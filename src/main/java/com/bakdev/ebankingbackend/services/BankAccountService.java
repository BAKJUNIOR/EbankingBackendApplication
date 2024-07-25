package com.bakdev.ebankingbackend.services;

import com.bakdev.ebankingbackend.entities.BankAccount;
import com.bakdev.ebankingbackend.entities.CurrentAccount;
import com.bakdev.ebankingbackend.entities.Customer;
import com.bakdev.ebankingbackend.entities.SavingAccount;
import com.bakdev.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.bakdev.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.bakdev.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance , double overDraft , Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance , double  interestRate , Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomer();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;

    void debit(String accountId , double amount , String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId , double amount , String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountIdSource, String accountIdDestination  , double amount ) throws BalanceNotSufficientException, BankAccountNotFoundException;

    List<BankAccount> bankAccountList();
}
