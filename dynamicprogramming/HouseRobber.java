package dynamicprogramming;

import java.util.HashMap;

public class HouseRobber {

    HashMap<Integer, Integer> currSteal = new HashMap<>();
    private int robHouses(int[] nums, int currHouse) {
        if (currHouse == 0) {
            return nums[0];
        }
        if (currHouse == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (!currSteal.containsKey(currHouse)) {
            int stealth = Math.max(robHouses(nums, currHouse - 1), robHouses(nums, currHouse - 2) + nums[currHouse]);
            currSteal.put(currHouse, stealth);
        }
        return currSteal.get(currHouse);
    }
    public int rob(int[] nums) {
        return robHouses(nums, nums.length-1);
    }
}
