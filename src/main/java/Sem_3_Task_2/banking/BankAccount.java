package Sem_3_Task_2.banking;

import Sem_3_Task_2.exceptions.InsufficientFundsException;
import Sem_3_Task_2.exceptions.InvalidAmountException;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 1000.0;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid transfer amount");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds on the account");
        }
        balance -= amount;
    }
}