/**
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements concrete strategies (Stack, Deque)
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * The focus is purely on algorithm interchangeability.
 *
 * Author: Developer
 * Version: 12.8
 */

import java.util.*;

public class UseCase12PalindromeCheckerApp {

    // INTERFACE - PalindromeStrategy
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // CLASS - StackStrategy
    static class StackStrategy implements PalindromeStrategy {
        /**
         * Implements palindrome validation using Stack.
         * @param input String to validate
         * @return true if palindrome, false otherwise
         */
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                stack.push(Character.toLowerCase(c));
            }
            for (char c : input.toCharArray()) {
                if (Character.toLowerCase(c) != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    // CLASS - DequeStrategy
    static class DequeStrategy implements PalindromeStrategy {
        /**
         * Implements palindrome validation using Deque.
         * @param input String to validate
         * @return true if palindrome, false otherwise
         */
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                deque.addLast(Character.toLowerCase(c));
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }

    // Application entry point
    public static void main(String[] args) {
        String input = "Level";
        System.out.println("Input: " + input);

        // Inject StackStrategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        boolean stackResult = stackStrategy.check(input);
        System.out.println("StackStrategy - Is Palindrome? : " + stackResult);

        // Inject DequeStrategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        boolean dequeResult = dequeStrategy.check(input);
        System.out.println("DequeStrategy - Is Palindrome? : " + dequeResult);
    }
}