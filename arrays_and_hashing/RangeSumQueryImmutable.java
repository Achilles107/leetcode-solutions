package arrays_and_hashing;

public class RangeSumQueryImmutable {
    class NumArray {

        private int[] prefixSum;
        public NumArray(int[] nums) {
            int length = nums.length;
            this.prefixSum = new int[length];
            int sum = 0;
            for (int i =0; i<length; i++) {
                sum += nums[i];
                this.prefixSum[i] = sum;
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return this.prefixSum[right];
            }
            return this.prefixSum[right] - this.prefixSum[left-1];
        }
    }
    public static void main(String[] args) {

    }
}
