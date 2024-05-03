package com.example.demo;

import com.example.demo.model.Balance;
import com.example.demo.model.Customer;
import com.example.demo.model.Transaction;
import com.example.demo.model.dto.Form2DTO;
import com.example.demo.repository.BalanceRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.TransactionRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BankingController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private BalanceRepo balanceRepo;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("/customerbyAccno")
    public String fetchCustomer(@RequestParam(name = "cusAccno") String cusAccno, Model model) {
        Optional<Customer> cus = customerRepo.findById(cusAccno);
        System.out.println(customerRepo.findById(cusAccno));
        Form2DTO form2dto = new Form2DTO();
        form2dto.setCusName(cus.get().getCus_name());
        form2dto.setBalance(cus.get().getBalance().getBal());
        form2dto.setCusAccno(cusAccno);
        model.addAttribute("form2dto", form2dto);


        return "customerdetails";
    }

    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("form2dto") Form2DTO form2dto, Model model) {
        System.out.println(form2dto);
        float amount = form2dto.getAmount();
        String cusno = form2dto.getCusAccno();
        float bal = form2dto.getBalance();
        float newBal = bal - amount;
        model.addAttribute("customer", newBal);
        return "withdrawaldetails";

    }

    @PostMapping("/customer")
    @ResponseStatus(value = HttpStatus.OK)
    public void addCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getCus_name());
        customerRepo.save(customer);
    }

    @GetMapping("/customerbyaccno/{cusAccno}")
    @ResponseStatus(value = HttpStatus.OK)
    public String getCustomer(@PathVariable("cusAccno") String cusAccno, Model model) {
        model.addAttribute("customer", new Customer());
//        model.addAttribute("message", "customer is" + customerRepo.findByCusAccno(cusAccno));
        return "customerdetails";
    }


    @PostMapping("/customerbal")
    @ResponseStatus(value = HttpStatus.OK)
    public void addbalance(@RequestBody Balance balance) {
        System.out.println(balance.getBal());
        balanceRepo.save(balance);

    }
    @PostMapping("/customerbal")
    @ResponseStatus(value = HttpStatus.OK)
    public void addtransaction(@RequestBody Balance balance) {
        System.out.println(balance.getBal());
        balanceRepo.save(balance);

    }
}
