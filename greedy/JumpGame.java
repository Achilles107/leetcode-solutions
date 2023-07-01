package greedy;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        if (nums[0] == 0)
            return false;
        int far = nums[0];
        for (int i =1; i< nums.length; i++){
            far = Math.max(far, nums[i]);
            if (i<far)
                return false;
        }
        return far == nums.length-1;
    }
    public static void main(String[] args) {

    }
}
