package strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> startIndices = new ArrayList<>();
        // make window
        int start = 0;
        int end;
        for (end = start; end < len; end++) {
            sCount[s.charAt(end) - 'a']++;
            pCount[p.charAt(end) - 'a']++;
        }
        // abab
        // start = 1; end = 3
        end = end - 1;
        for (start = 0; start <= s.length() - len; start++) {
            // compare strings
            //System.out.println(s.substring(start, end+1));
            if (start != 0) {
                sCount[(s.charAt(start - 1) - 'a')]--;
                sCount[s.charAt(end) - 'a']++;
            }
            boolean isEqual = true;
            for (int i = 0; i < 26; i++) {
                if (sCount[i] != pCount[i]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                startIndices.add(start);
            }
            end++;
        }
        return startIndices;
    }
}
