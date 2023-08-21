package arrays_and_hashing;

public class NumberofZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        int length = nums.length;
        long noOfSubsArrays = 0;
        int subLen = 0;
        long[] map = new long[length+1];

        for (int i =0; i<length; i++) {
            if (nums[i] == 0) {
                subLen++;
                if (map[subLen] == 0) {
                    map[subLen] = map[subLen-1] + subLen;
                }
            }

            if (nums[i] != 0 || i == length-1) {
                noOfSubsArrays += map[subLen];
                subLen = 0;
            }
        }
        return noOfSubsArrays;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,4,0,0,4};
        System.out.println(new NumberofZeroFilledSubarrays().zeroFilledSubarray(nums));
    }
}
