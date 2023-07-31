package Sem_3_Task_1;

import Sem_3_Task_1.calculations.Calculator;
import Sem_3_Task_1.exceptions.InvalidInputException;

import java.util.Scanner;

public class Main {
    /**
     * Main method to perform arithmetic operations on two numbers entered by the user.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            double num1 = readNumber(scanner, "Enter the first number: ");
            double num2 = readNumber(scanner, "Enter the second number: ");
            scanner.close();

            Calculator calculator = new Calculator();

            double sum = calculator.add(num1, num2);
            System.out.println("Sum: " + sum);

            double difference = calculator.subtract(num1, num2);
            System.out.println("Difference: " + difference);

            double product = calculator.multiply(num1, num2);
            System.out.println("Product: " + product);

            double quotient = calculator.divide(num1, num2);
            System.out.println("Quotient: " + quotient);

            double power = calculator.calculatePower(num1, num2);
            System.out.println("Power: " + power);

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        }
    }

    /**
     * Reads a number entered by the user from the console.
     *
     * @param scanner The Scanner object used for user input.
     * @param prompt  The prompt message to display to the user.
     * @return The number entered by the user.
     */
    private static double readNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.nextLine(); // Clear invalid input
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        return scanner.nextDouble();
    }
}
