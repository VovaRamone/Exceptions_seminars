package Sem_3_Task_1.calculations;

import Sem_3_Task_1.exceptions.InvalidInputException;

public class Calculator {
    /**
     * Adds two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The sum of num1 and num2.
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The difference between num1 and num2.
     */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Multiplies two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The product of num1 and num2.
     */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Divides the first number by the second number.
     *
     * @param num1 The numerator.
     * @param num2 The denominator.
     * @return The quotient of num1 divided by num2.
     * @throws InvalidInputException If the second number (denominator) is zero.
     */
    public double divide(double num1, double num2) throws InvalidInputException {
        if (num2 == 0) {
            throw new InvalidInputException("Invalid input: Division by zero is not allowed.");
        }
        return num1 / num2;
    }

    /**
     * Calculates the power of the first number raised to the second number.
     *
     * @param base     The base number.
     * @param exponent The exponent number.
     * @return The result of raising the base to the exponent.
     * @throws InvalidInputException If the base is zero and the exponent is negative.
     */
    public double calculatePower(double base, double exponent) throws InvalidInputException {
        if (base == 0 && exponent < 0) {
            throw new InvalidInputException("Invalid input: base cannot be zero and exponent cannot be negative.");
        }
        return Math.pow(base, exponent);
    }
}
