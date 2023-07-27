package Sem_2_Task_4;

public class BankAccount {
    private double balance;
    private static final double MAX_BALANCE = 1000.0;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) throws MaxBalanceExceededException {
        if (balance + amount > MAX_BALANCE) {
            throw new MaxBalanceExceededException("Max balance exceeded.");
        }
        balance += amount;
    }

    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

