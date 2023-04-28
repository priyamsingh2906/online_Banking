# Banking Website

The Banking Website is a Java Spring Boot application that provides basic banking functionalities such as transferring money, withdrawing money, depositing money, and advanced features like transferring money through Interac, currency conversion, daily transfer limit, minimum balance requirement, and admin privileges.

## Features

- Transfer money between accounts
- Withdraw money from an account
- Deposit money into an account
- Transfer money through Interac
- Currency conversion
- Daily transfer limit of $1000
- Minimum balance requirement of Rs 10,000
- Admin and non-admin privileges on banking features

## Technologies Used

- Java 8+
- Spring Boot
- Spring Data JPA
- Spring MVC
- Maven (Dependency Management)

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven

For the current commit, few features such as "Transfer money through interac" and "admin and non-admin privileges" are not available.

UserService
The UserService class is responsible for handling the business logic related to user operations in the banking system. It provides methods for transferring money between accounts, withdrawing money, depositing money, retrieving account balance, and determining admin privileges.

The transferMoney() method allows transferring funds from one user account to another. It performs necessary validations such as checking the sender's account balance and applying the daily transfer limit. If the transfer is valid, it updates the sender's and receiver's account balances accordingly.

The withdrawMoney() method enables users to withdraw funds from their accounts. It verifies the account balance against the minimum balance requirement and throws an exception if the withdrawal would violate this limit.

The depositMoney() method allows users to deposit funds into their accounts. It updates the account balance by adding the deposited amount.

The getAccountBalance() method retrieves the account balance of a user based on the provided account number.

The isAdmin() method determines whether a user has admin privileges. This can be customized based on your application's specific requirements.

BankingController
The BankingController class serves as the REST API controller for handling banking-related HTTP requests. It exposes endpoints for performing banking operations such as transferring money, withdrawing money, depositing money, and currency conversion.

The transferMoney() endpoint allows users to transfer funds between accounts. It accepts the sender's and receiver's account numbers and the transfer amount as input. It invokes the UserService to handle the transfer operation and returns an appropriate response.

The withdrawMoney() endpoint enables users to withdraw funds from their accounts. It accepts the account number and withdrawal amount as input, and it invokes the corresponding method in the UserService to handle the withdrawal operation.

The depositMoney() endpoint allows users to deposit funds into their accounts. It accepts the account number and deposit amount as input and invokes the corresponding method in the UserService to handle the deposit operation.

The convertCurrency() endpoint performs currency conversion. It accepts the source currency, target currency, and amount as input. It utilizes the CurrencyConverterService to calculate the converted amount and returns the result.
