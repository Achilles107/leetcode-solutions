package arrays_and_hashing;

public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2)
            return true;
        int allowedChanges = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (i >= 1) {
                    if (nums[i-1] > nums[i+1]) {
                        nums[i+1] = nums[i];
                    } else {
                        nums[i] = nums[i+1];
                    }
                }
                allowedChanges--;
            }

            if (allowedChanges < 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {7,4,9,17};
        System.out.println(new NondecreasingArray().checkPossibility(nums));
    }
}
