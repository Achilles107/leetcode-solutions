package two_pointers;

import java.util.HashMap;

public class MaxNumberofKSumPairs {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int noOfPairs = 0;
        for (int num : nums) {
            int diff = k - num;
            if (diff == num) {
                if (counts.get(num) > 1) {
                    counts.put(num, counts.get(num) - 2);
                    noOfPairs += 1;
                }
            } else {
                if (counts.containsKey(k - num) && counts.get(k - num) > 0 && counts.get(num) > 0) {
                    counts.put(k - num, counts.get(k - num) - 1);
                    counts.put(num, counts.get(num) - 1);
                    noOfPairs += 1;
                }
            }
        }
        return noOfPairs;
    }
}
