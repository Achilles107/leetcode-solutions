package backtracking;

import java.util.*;

public class SubsetsII {
    private final List<List<Integer>> result = new ArrayList<>();

    private void trace(int nums[], int n, List<Integer> subset, int start, Map<Integer, Integer> count){
        result.add(new ArrayList<>(subset));
        for (int i=start; i<n; i++){
            if (count.get(nums[i]) > 0) {
                subset.add(nums[i]);
                count.put(nums[i], count.get(nums[i]) - 1);
                trace(nums, n, subset, i, count);
                subset.remove(subset.size()-1);
                count.put(nums[i], count.get(nums[i]) + 1);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        int subs[] = new int[count.size()];
        int i =0;
        for (Integer key: count.keySet()){
            subs[i] = key;
            i++;
        }
        trace(subs, subs.length, new ArrayList<>(), 0, count);
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,2,2};
        System.out.println(new SubsetsII().subsetsWithDup(nums));
    }
}
