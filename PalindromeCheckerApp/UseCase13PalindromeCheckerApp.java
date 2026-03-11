/**
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 *
 * Use Case 13: Performance Comparison
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 * At this stage, the application:
 * - Uses multiple palindrome strategy implementations
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * The goal is to introduce benchmarking concepts.
 *
 * Author: Developer
 * Version: 13.0
 */

public class UseCase13PalindromeCheckerApp {

    // Approach 1: Reverse string comparison
    public static boolean isPalindromeReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }

    // Approach 2: Two-pointer technique
    public static boolean isPalindromeTwoPointer(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Benchmarking method
    public static long measureExecutionTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        String input = "LeveL";

        System.out.println("Input: " + input);

        // Test Reverse Method
        long reverseTime = measureExecutionTime(() -> {
            boolean result = isPalindromeReverse(input);
            System.out.println("Reverse Method - Is Palindrome? " + result);
        });
        System.out.println("Execution Time (Reverse): " + reverseTime + " ns");

        // Test Two-Pointer Method
        long twoPointerTime = measureExecutionTime(() -> {
            boolean result = isPalindromeTwoPointer(input);
            System.out.println("Two-Pointer Method - Is Palindrome? " + result);
        });
        System.out.println("Execution Time (Two-Pointer): " + twoPointerTime + " ns");

        // Comparison
        System.out.println("\nPerformance Comparison:");
        if (reverseTime < twoPointerTime) {
            System.out.println("Reverse method is faster.");
        } else if (twoPointerTime < reverseTime) {
            System.out.println("Two-pointer method is faster.");
        } else {
            System.out.println("Both methods performed equally.");
        }
    }
}