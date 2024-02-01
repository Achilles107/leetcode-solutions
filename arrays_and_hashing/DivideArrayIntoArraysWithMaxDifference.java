package arrays_and_hashing;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int len = nums.length;
        int[][] result = new int[len / 3][3];
        int smIdx = 0;
        Arrays.sort(nums);
        int idx = 0;
        while (smIdx + 2 < len) {
            int smallest = nums[smIdx];
            int largest = nums[smIdx + 2];

            int diff = largest - smallest;
            if (diff > k) {
                return new int[][]{};
            }
            result[idx][0] = nums[smIdx];
            result[idx][1] = nums[smIdx + 1];
            result[idx][2] = nums[smIdx + 2];

            smIdx = smIdx + 3;
            idx += 1;
        }
        return result;
    }
}
