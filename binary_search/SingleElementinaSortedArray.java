package binary_search;

public class SingleElementinaSortedArray {

    private int[] nums;
    private  int len;

    private boolean isEven(int mid, int right) {
        return (right - mid) % 2 == 0;
    }

    private int findSingleElement(int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isEven = isEven(left, mid);

            if (mid - 1 >= 0 && this.nums[mid-1] == this.nums[mid]) {
                if (isEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (mid + 1 < this.len && this.nums[mid+1] == this.nums[mid]) {
                if (isEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            }
            else {
                return this.nums[mid];
            }
        }
        return findSingleElement(left, right);
    }
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int right = len-1;
        this.nums = nums;
        this.len = len;

        return findSingleElement(0, right);
    }
    public static void main(String[] args) {

    }
}
