package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private boolean isPalindrome(String string){
        StringBuilder revString = new StringBuilder(string);
        //System.out.println(revString.reverse());
        return string.equals(revString.reverse().toString());
    }

    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> firstSplit = new ArrayList<>();
        trace(firstSplit, 0, s);
        return result;
    }

    private void trace(List<String> firstSplit, int start, String s) {
        if (start >= s.length()){
            result.add(new ArrayList<>(firstSplit));
        }

        for (int end = start; end < s.length(); end++){
            if (isPalindrome(s.substring(start, end + 1))){
                firstSplit.add(s.substring(start, end + 1));
                trace(firstSplit, end + 1, s);
                firstSplit.remove(firstSplit.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "ababab";
        System.out.println(new PalindromePartitioning().partition(str));
    }
}
