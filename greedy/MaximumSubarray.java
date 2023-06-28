package greedy;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int numPos=0, numNeg = 0;
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for (int i =0; i<nums.length; i++){
            if (nums[i] <= 0)
                numNeg++;
            else
                numPos++;
            maxVal = Math.max(maxVal, nums[i]);
            sum += nums[i];
        }
        if (numPos == nums.length)
            return sum;
        if (numNeg == nums.length)
            return maxVal;
        if (numPos == 1)
            return maxVal;

        int maxSum = nums[0], currSum = nums[0];
        for (int i =1; i<nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            //System.out.println("C " + currSum);
            maxSum = Math.max(maxSum, currSum);
            //System.out.println("M " + maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
