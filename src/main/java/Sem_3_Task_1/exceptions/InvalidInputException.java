package Sem_3_Task_1.exceptions;

public class InvalidInputException extends Exception {
    /**
     * Constructs a new InvalidInputException with the specified error message.
     *
     * @param message The error message.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
