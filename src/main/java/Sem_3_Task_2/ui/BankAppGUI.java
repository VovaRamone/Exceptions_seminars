package Sem_3_Task_2.ui;

import Sem_3_Task_2.banking.BankAccount;
import Sem_3_Task_2.exceptions.InsufficientFundsException;
import Sem_3_Task_2.exceptions.InvalidAmountException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAppGUI extends JFrame {
    private JTextField amountField;
    private JButton transferButton;
    private JLabel balanceLabel;
    private BankAccount bankAccount;

    public BankAppGUI() {
        setTitle("Banking Transaction System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        bankAccount = new BankAccount();

        balanceLabel = new JLabel("Balance: $" + bankAccount.getBalance());
        add(balanceLabel);

        amountField = new JTextField(10);
        add(new JLabel("Enter Amount: "));
        add(amountField);

        transferButton = new JButton("Transfer");
        add(transferButton);

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    bankAccount.transfer(amount);
                    balanceLabel.setText("Balance: $" + bankAccount.getBalance());
                    JOptionPane.showMessageDialog(BankAppGUI.this, "Transfer successful.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BankAppGUI.this, "Invalid input: Please enter a valid number.");
                } catch (InvalidAmountException ex) {
                    JOptionPane.showMessageDialog(BankAppGUI.this, ex.getMessage());
                } catch (InsufficientFundsException ex) {
                    JOptionPane.showMessageDialog(BankAppGUI.this, ex.getMessage());
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankAppGUI().setVisible(true);
            }
        });
    }
}