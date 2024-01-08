package strings;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int len = s.length();
        // take count of each character
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        int palinLen = len;
        // if even then all count shoud be even
        for (char ch : count.keySet()) {
            if (count.get(ch) % 2 != 0) {
                palinLen--;
            }
        }

        return len == palinLen ? palinLen : palinLen + 1;
    }
}
