package Sem_2_Task_3;

import java.util.Scanner;

public class NumberValidation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            validateNumber1(num1);

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            validateNumber2(num2);

            int sum = num1 + num2;
            validateSum(sum);

            System.out.print("Enter the third number: ");
            int num3 = scanner.nextInt();
            validateNumber3(num3);

            scanner.close();

            System.out.println("Validation passed successfully.");
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    public static void validateNumber1(int num) {
        if (num > 100) {
            throw new NumberOutOfRangeException("First number out of range");
        }
    }

    public static void validateNumber2(int num) {
        if (num < 0) {
            throw new NumberOutOfRangeException("Second number out of range");
        }
    }

    public static void validateSum(int sum) {
        if (sum < 10) {
            throw new NumberSumException("The sum of the first and second numbers is too small.");
        }
    }

    public static void validateNumber3(int num) {
        if (num == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
    }
}
