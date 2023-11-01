package arrays_and_hashing;

import java.util.Set;
import java.util.TreeSet;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        int[] prefixSum = new int[size];
        int sum = 0;
        for (int i =0; i<size; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        int numberOfArrays = 0;
        Set<Integer> seen = new TreeSet<>();
        for (int prefix: prefixSum) {
            if (seen.add(prefix % k)) {
                numberOfArrays++;
            }
        }
        return numberOfArrays;
    }
    public static void main(String[] args) {

    }
}
