public class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] arr = new int[5];
        // Trying to access an element outside the array bounds
        int value = arr[10];
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int numerator = 10;
        int denominator = 0;
        // Trying to divide by zero
        int result = numerator / denominator;
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String text = "abc";
        // Trying to convert a non-numeric string to an integer
        int number = Integer.parseInt(text);
    }
}
