package two_pointers;

import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();

        int len = nums.length;
        int movingIndx = k % len;

        for (int i =0; i<len-movingIndx; i++) {
            queue.addLast(nums[i]);
        }
        for (int i = len-1; i>=len-movingIndx; i--) {
            queue.addFirst(nums[i]);
        }
        int i =0;
        while (!queue.isEmpty()) {
            nums[i] = queue.pollFirst();
            i++;
        }
    }
    public static void main(String[] args) {

    }
}
