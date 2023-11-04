package stack;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        int idx = 0;

        Stack<Integer> pushedStack = new Stack<>();


        for (int push: pushed) {
            pushedStack.push(push);
            while (!pushedStack.isEmpty() && idx < len && pushedStack.peek() == popped[idx]) {
                pushedStack.pop();
                idx++;
            }
        }
        return pushedStack.isEmpty();

    }
    public static void main(String[] args) {

    }
}
