package com.bakdev.ebankingbackend;

import com.bakdev.ebankingbackend.entities.AccountOperation;
import com.bakdev.ebankingbackend.entities.CurrentAccount;
import com.bakdev.ebankingbackend.entities.Customer;
import com.bakdev.ebankingbackend.entities.SavingAccount;
import com.bakdev.ebankingbackend.enums.AccountStatus;
import com.bakdev.ebankingbackend.enums.OperationType;
import com.bakdev.ebankingbackend.repositories.AccountOperationRepository;
import com.bakdev.ebankingbackend.repositories.BankAccountRepository;
import com.bakdev.ebankingbackend.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);

    }

    // Faire un test pour insérer les éléments dans la base de donnée
    @Bean
    // on veu exécutez cette instruction au démarrage
    CommandLineRunner star(CustomerRepository customerRepository,
                           BankAccountRepository bankAccountRepository,
                           AccountOperationRepository accountOperationRepository) {
        return args -> {
            // Créé 3 clients
            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });

            //Pour chaqe client enregistrer un compte courant & épargne

            customerRepository.findAll().forEach(cust -> {

                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 900000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);


                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 900000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);

            });

            bankAccountRepository.findAll().forEach(acc -> {
                for (int i = 0; i < 10; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random() * 12000);
                    accountOperation.setOperationType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);

                    accountOperationRepository.save(accountOperation);
                }
            });

        };


    }
}
