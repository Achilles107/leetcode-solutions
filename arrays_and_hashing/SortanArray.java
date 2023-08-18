package arrays_and_hashing;

import java.util.PriorityQueue;

public class SortanArray {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        PriorityQueue<Integer> smallestFirst = new PriorityQueue<>();
        for (int num: nums) {
            smallestFirst.offer(num);
        }
        for (int i=0; i<len; i++) {
            nums[i] = smallestFirst.poll();
        }
        return nums;
    }
    public static void main(String[] args) {

    }
}
