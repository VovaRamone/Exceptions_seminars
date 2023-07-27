package Sem_2_Task_4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public synchronized void createAccount(double initialBalance) {
        BankAccount account = new BankAccount(initialBalance);
        accounts.add(account);
    }

    public void replenish(int accountIndex, double amount) throws MaxBalanceExceededException {
        BankAccount account = accounts.get(accountIndex);
        account.deposit(amount);
    }

    public void withdraw(int accountIndex, double amount) throws InsufficientFundsException {
        BankAccount account = accounts.get(accountIndex);
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount(500.0);
        bank.createAccount(800.0);

        // Test 1: Replenish money to the same account from two threads
        Runnable replenishTask1 = () -> {
            try {
                bank.replenish(0, 300.0);
            } catch (MaxBalanceExceededException e) {
                System.out.println(e.getMessage());
            }
        };

        Runnable replenishTask2 = () -> {
            try {
                bank.replenish(0, 200.0);
            } catch (MaxBalanceExceededException e) {
                System.out.println(e.getMessage());
            }
        };

        // Test 2: Withdraw money from the same account from two threads
        Runnable withdrawTask1 = () -> {
            try {
                bank.withdraw(1, 300.0);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        };

        Runnable withdrawTask2 = () -> {
            try {
                bank.withdraw(1, 200.0);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        };

        // Start the threads to simulate concurrent transactions
        Thread thread1 = new Thread(replenishTask1);
        Thread thread2 = new Thread(replenishTask2);
        Thread thread3 = new Thread(withdrawTask1);
        Thread thread4 = new Thread(withdrawTask2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

