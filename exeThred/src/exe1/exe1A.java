package exe1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class exe1A {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of Fibonacci numbers to generate: ");
            int n = scanner.nextInt();
            long[] fibonacciSequence = new long[n];
            Thread fibonacciThread = new Thread(() -> {
                generateFibonacciSequence(fibonacciSequence);
            });

            fibonacciThread.start();
            try {
                fibonacciThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Generated Fibonacci sequence:");
            for (long num : fibonacciSequence) {
                System.out.print(num + " ");
            }

        }
    private static void generateFibonacciSequence(long[] sequence) {
        if (sequence.length >= 1) {
            sequence[0] = 0; // First Fibonacci number
        }
        if (sequence.length >= 2) {
            sequence[1] = 1; // Second Fibonacci number
        }

        for (int i = 2; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
    }
}
