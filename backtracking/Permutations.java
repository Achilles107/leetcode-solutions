package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {

    private List<List<Integer>> result = new ArrayList<>();

    private void trace(int nums[], List<Integer> permutation, int n, Map<Integer, Integer> count){
        if (permutation.size() == n){
            result.add(new ArrayList<>(permutation));
        }
        for (int i =0; i<n; i++){
            if (count.get(nums[i]) > 0) {
                permutation.add(nums[i]);
                count.put(nums[i], count.get(nums[i]) - 1);
                trace(nums, permutation, n, count);
                count.put(nums[i], count.get(nums[i]) + 1);
                permutation.remove(permutation.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i: nums){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        trace(nums, new ArrayList<>(), nums.length, count);
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {0,1};
        System.out.println(new Permutations().permute(nums));
    }
}
