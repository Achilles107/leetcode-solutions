package stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> smallest = new Stack<>();

        for (char ch: num.toCharArray()) {
            if (smallest.isEmpty()) {
                smallest.push(ch);
                continue;
            }
            while (!smallest.isEmpty() && smallest.peek() - '0' > ch - '0' && k > 0) {
                k--;
                smallest.pop();
            }
            smallest.push(ch);
        }
        StringBuilder result = new StringBuilder();

        while(k-->0) {
            smallest.pop();
        }
        while (!smallest.isEmpty()) {
            result.append(smallest.pop());
        }
        result.reverse();
        // remove zeros
        int firstNumber = -1;
        for (int i=0; i<result.length(); i++) {
            if (result.charAt(i) != '0') {
                firstNumber = i;
                break;
            }
        }
        return firstNumber == -1 || num.length() <= 1 ? "0" : result.substring(firstNumber, result.length());
    }
    public static void main(String[] args) {

    }
}
