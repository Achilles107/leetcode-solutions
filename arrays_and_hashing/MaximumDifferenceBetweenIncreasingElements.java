package arrays_and_hashing;

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int i = 0;
        int j = 1;

        int len = nums.length;
        int max_diff = -1;
        while (i < len && j < len) {
            int diff = nums[j] - nums[i];

            if (diff < 0) {
                i = j;
            }
            max_diff = Math.max(max_diff, diff);
            j += 1;
        }
        return max_diff <= 0 ? -1 : max_diff;
    }
}
