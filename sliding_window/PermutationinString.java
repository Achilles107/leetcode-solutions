package sliding_window;

public class PermutationinString {

    private int[] formHashMap(String s) {
        int[] hasMap = new int[26];
        for (char ch: s.toCharArray()) {
            hasMap[ch-'a'] += 1;
        }
        return hasMap;
    }

    private boolean isPermutation(int[] hasMap1, int[] hasMap2) {
        for (int i =0; i<26; i++) {
            if (hasMap2[i] != hasMap1[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] hasMap2 = new int[26];
        int[] hashMap1 = formHashMap(s1);

        int window_size = s1.length();
        int i =0;
        int j =0;

        while (i<s2.length() && j<s2.length()) {
            hasMap2[s2.charAt(j)-'a'] += 1;
            j++;

            if (j-i == window_size) {
                if (isPermutation(hasMap2, hashMap1)) {
                    return true;
                }
                hasMap2[s2.charAt(i)-'a'] -= 1;
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new PermutationinString().checkInclusion("ab", "eidbaooo"));
    }
}
