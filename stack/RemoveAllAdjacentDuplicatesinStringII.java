package stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {

    class Alphabet {

        char ch;
        int count;

        public Alphabet(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        int len = s.length();
        Stack<Alphabet> stack = new Stack<>();
        for (int idx =0; idx<len; idx++) {
            if (stack.isEmpty()) {
                stack.push(new Alphabet(s.charAt(idx), 1));
                continue;
            }
            int count = 0;
            if (stack.peek().ch == s.charAt(idx)) {
                count = stack.pop().count;
                stack.push(new Alphabet(s.charAt(idx), count+1));
                if (stack.peek().count == k)
                    stack.pop();
                continue;
            }
            if (stack.peek().ch != s.charAt(idx)) {
                stack.push(new Alphabet(s.charAt(idx), 1));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Alphabet currLetter = stack.pop();
            for (int i =0; i<currLetter.count; i++) {
                result.append(currLetter.ch);
            }
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
    }
}
