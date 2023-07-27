package Sem_2_Task_1;

import java.util.Scanner;

public class PositiveNumberChecker {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            scanner.close();

            checkNumber(number);
            System.out.println("The number is correct");
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    public static void checkNumber(int number) {
        if (number <= 0) {
            throw new InvalidNumberException("Invalid number");
        }
    }
}
