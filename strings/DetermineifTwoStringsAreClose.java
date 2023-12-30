package strings;

import java.util.Arrays;

public class DetermineifTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2)
            return false;
        int[] wordCount1 = new int[26];
        int[] wordCount2 = new int[26];

        for (char ch: word1.toCharArray()) {
            wordCount1[ch - 'a'] += 1;
        }
        for (char ch: word2.toCharArray()) {
            wordCount2[ch - 'a'] += 1;
        }
        for (int i = 0; i<26; i++) {
            if (wordCount1[i] == 0 && wordCount2[i] != 0)
                return false;
            if (wordCount1[i] != 0 && wordCount2[i] == 0)
                return false;
        }
        Arrays.sort(wordCount1);
        Arrays.sort(wordCount2);
        return Arrays.equals(wordCount1, wordCount2);
    }
}
