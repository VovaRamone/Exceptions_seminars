package Sem_2_Task_2;

import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            scanner.close();

            double result = divideNumbers(num1, num2);
            System.out.println("Result of division: " + result);
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    public static double divideNumbers(double num1, double num2) {
        if (num2 == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }

        return num1 / num2;
    }
}
