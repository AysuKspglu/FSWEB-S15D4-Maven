package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {
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
}

