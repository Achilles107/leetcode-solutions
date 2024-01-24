package arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertanArrayIntoa2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        // O(n)
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // O(n)
        int max = 0;
        for (Integer num : count.keySet()) {
            max = Math.max(max, count.get(num));
        }

        // O(max) < O(n)
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            result.add(new ArrayList<>());
        }

        // O(n)
        for (Integer num : count.keySet()) {
            int freq = count.get(num);
            for (int i = 0; i < freq; i++) {
                result.get(i).add(num);
            }
        }

        return result;
    }
}
