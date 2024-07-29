package com.bakdev.ebankingbackend;

import com.bakdev.ebankingbackend.dtos.CustomerDTO;
import com.bakdev.ebankingbackend.entities.*;
import com.bakdev.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.bakdev.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.bakdev.ebankingbackend.exceptions.CustomerNotFoundException;
import com.bakdev.ebankingbackend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                bankAccountService.saveCustomer(new CustomerDTO());
            });

            bankAccountService.listCustomer().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random() * 90000, 9000, customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random() * 120000, 5.5, customer.getId());

                    List<BankAccount> bankAccounts = bankAccountService.bankAccountList();

                    for (BankAccount bankAccount : bankAccounts) {
                        for (int i = 0; i < 10; i++) {
                            bankAccountService.credit(bankAccount.getId(), 10000 + Math.random() * 120000, "Credit");
                            bankAccountService.debit(bankAccount.getId(), 1000 + Math.random() * 9000, "Debit");
                        }
                    }
                } catch (CustomerNotFoundException | BankAccountNotFoundException | BalanceNotSufficientException e) {
                    e.printStackTrace();
                }
            });
        };
    }
}
