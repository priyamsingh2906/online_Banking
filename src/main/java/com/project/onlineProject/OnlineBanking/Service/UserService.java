package com.project.onlineProject.OnlineBanking.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.onlineProject.OnlineBanking.Repository.UserRepository;
import com.project.onlineProject.OnlineBanking.Entity.UserEntity;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void transferMoney(String senderAccountNumber, String receiverAccountNumber, double amount) {
        UserEntity sender = getUserByAccountNumber(senderAccountNumber);
        UserEntity receiver = getUserByAccountNumber(receiverAccountNumber);

        if (sender.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance for transfer.");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        userRepository.save(sender);
        userRepository.save(receiver);
    }

    @Transactional
    public void withdrawMoney(String accountNumber, double amount) {
        UserEntity user = getUserByAccountNumber(accountNumber);

        if (user.getBalance() - amount < 10000) {
            throw new IllegalArgumentException("Withdrawal amount exceeds the minimum balance requirement.");
        }

        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);
    }

    @Transactional
    public void depositMoney(String accountNumber, double amount) {
        UserEntity user = getUserByAccountNumber(accountNumber);

        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);
    }

    public double getAccountBalance(String accountNumber) {
        UserEntity user = getUserByAccountNumber(accountNumber);
        return user.getBalance();
    }

    public boolean isAdmin(String accountNumber) {
        // Logic to check if the user with the given account number has admin privileges
        // For simplicity, let's assume admin account numbers start with "ADMIN"
        return accountNumber.startsWith("ADMIN");
    }

    private UserEntity getUserByAccountNumber(String accountNumber) {
        UserEntity user = userRepository.findByAccountNumber(accountNumber);

        if (user == null) {
            throw new IllegalArgumentException("Invalid account number.");
        }

        return user;
    }
}
