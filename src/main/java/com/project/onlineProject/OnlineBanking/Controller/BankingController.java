package com.project.onlineProject.OnlineBanking.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.onlineProject.OnlineBanking.Service.CurrencyConverterService;
//import com.project.onlineProject.OnlineBanking.Service.CurrencyConverterService;
import com.project.onlineProject.OnlineBanking.Service.UserService;


@RestController
@RequestMapping("/api/banking")
public class BankingController {
    private final UserService userService;
    private final CurrencyConverterService currencyConverterService;

    public BankingController(UserService userService, CurrencyConverterService currencyConverterService) {
        this.userService = userService;
        this.currencyConverterService = currencyConverterService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestParam("senderAccountNumber") String senderAccountNumber,@RequestParam("recieverAccountNumber") String recieverAccountNumber, @RequestParam("amount") double amount) {
        try {
            userService.transferMoney(senderAccountNumber, recieverAccountNumber, amount);
            return ResponseEntity.ok("Money transferred successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdrawMoney(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        try {
            userService.withdrawMoney(accountNumber, amount);
            return ResponseEntity.ok("Money withdrawn successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> depositMoney(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") double amount) {
        try {
            userService.depositMoney(accountNumber, amount);
            return ResponseEntity.ok("Money deposited successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getAccountBalance(@RequestParam("accountNumber") String accountNumber) {
        try {
            double balance = userService.getAccountBalance(accountNumber);
            return ResponseEntity.ok(balance);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/isAdmin")
    public ResponseEntity<Boolean> checkAdminPrivilege(@RequestParam("accountNumber") String accountNumber) {
        try {
            boolean isAdmin = userService.isAdmin(accountNumber);
            return ResponseEntity.ok(isAdmin);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/currency-conversion")
    public ResponseEntity<Double> convertCurrency(@RequestParam("amount") double amount, @RequestParam("fromCurrency") String fromCurrency, @RequestParam("toCurrency") String toCurrency) {
        try {
            double convertedAmount = currencyConverterService.convertCurrency(amount, fromCurrency, toCurrency);
            return ResponseEntity.ok(convertedAmount);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Other API endpoints for admin privileges, additional features, etc.
    // ...
}