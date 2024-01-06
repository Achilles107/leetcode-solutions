package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        HashMap<Character, Integer> firstIndices = new HashMap<Character, Integer>();
        HashMap<Character, Integer> lastIndices = new HashMap<Character, Integer>();

        for (int i = 0; i < len; i++) {
            if (!firstIndices.containsKey(s.charAt(i))) {
                firstIndices.put(s.charAt(i), i);
            }
            lastIndices.put(s.charAt(i), i);
        }

        int noOfPalindromes = 0;
        for (char key : firstIndices.keySet()) {
            int start = firstIndices.get(key);
            int last = lastIndices.get(key);

            if (((last - start) + 1) >= 3) {
                Set<Character> set = new HashSet<>();
                for (int i = start + 1; i < last; i++) {
                    set.add(s.charAt(i));
                }
                noOfPalindromes += set.size();
            }
        }
        return noOfPalindromes;
    }
}
