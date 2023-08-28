package stack;

import java.util.Stack;

public class RemovingStarsFromaString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '*' && !stack.isEmpty()) {
                stack.pop();
            }
            else {
                stack.add(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {

    }
}
