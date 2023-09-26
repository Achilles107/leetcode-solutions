package sliding_window;

public class MaximumNumberofVowelsinaSubstringofGivenLength {

    private boolean isVowel(int alphabet) {
        return alphabet == 0 || alphabet == 'e' - 'a' || alphabet == 'i' - 'a' || alphabet == 'o' - 'a' || alphabet == 'u' - 'a';
    }
    private int countVowels(int[] alphabetsCount) {
        int noOfVowels = 0;
        for (int i =0; i<26; i++) {
            if (isVowel(i)) {
                noOfVowels += alphabetsCount[i];
            }
        }
        return noOfVowels;
    }
    public int maxVowels(String s, int k) {
        int[] alphabetCount = new int[26];

        int left =0;
        int right = 0;
        int maxVowel = 0;
        while (left < s.length() && right < s.length()) {
            alphabetCount[s.charAt(right)-'a'] += 1;
            right++;

            if (right-left == k) {
                int noOfVowels = countVowels(alphabetCount);
                maxVowel = Math.max(noOfVowels, maxVowel);

                alphabetCount[s.charAt(left) - 'a'] -= 1;
                left++;
            }
        }
        return maxVowel;
    }
    public static void main(String[] args) {

    }
}
