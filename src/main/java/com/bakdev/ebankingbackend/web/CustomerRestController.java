package com.bakdev.ebankingbackend.web;

import com.bakdev.ebankingbackend.dtos.CustomerDTO;
import com.bakdev.ebankingbackend.entities.Customer;
import com.bakdev.ebankingbackend.exceptions.CustomerNotFoundException;
import com.bakdev.ebankingbackend.services.BankAccountService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;


    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomer();
    }

    @GetMapping("/customers/{id}") // consulter un client voir les details
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerID) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerID);
    }

    @PostMapping("/customers")
    public  CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("/customers/{customerId}")
    public  CustomerDTO updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return bankAccountService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public  void deleteCustomer(@PathVariable Long id){
         bankAccountService.deleteCustomer(id);
    }
}
