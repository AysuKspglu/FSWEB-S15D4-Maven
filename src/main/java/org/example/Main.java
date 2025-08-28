package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    // ✅ Palindrome Kontrolü
    public static boolean checkForPalindrome(String input) {
        if (input == null) return false;

        // harf ve rakam dışındaki karakterleri temizle + küçük harfe çevir
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    // ✅ Decimal → Binary dönüşüm
    public static String convertDecimalToBinary(int number) {
        if (number == 0) return "0";

        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        // Elle denemeler
        System.out.println(checkForPalindrome("I did, did I?")); // true
        System.out.println(convertDecimalToBinary(13)); // 1101
    }
}

