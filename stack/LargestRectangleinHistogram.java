package stack;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = Integer.MIN_VALUE;
        int len = heights.length;

        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 1 && heights[stack.peek()] >= heights[i]) {
                int top = stack.pop();
                maxArea = Math.max(maxArea, (i - stack.peek() - 1) * heights[top]);
            }
            stack.push(i);
        }

        while (stack.size() > 1) {
            int top = stack.pop();
            maxArea = Math.max(maxArea, (len - stack.peek() - 1) * heights[top]);
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
