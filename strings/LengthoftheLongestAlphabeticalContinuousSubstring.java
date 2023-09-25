package strings;

public class LengthoftheLongestAlphabeticalContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int len = s.length();
        int longestLength = 0;
        char currChar = '#';
        int lengthSubstring = 0;
        for (int idx =0; idx<len; idx++) {

            if ((s.charAt(idx) - currChar) == 1) {
                lengthSubstring++;
                longestLength = Math.max(longestLength, lengthSubstring);
                currChar = s.charAt(idx);
            }
            else {
                lengthSubstring = 1;
                currChar = s.charAt(idx);
            }
        }
        return Math.max(longestLength, lengthSubstring);
    }
    public static void main(String[] args) {

    }
}
