package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private final List<List<Integer>> outer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        findSubs(0, nums, new ArrayList<>());
        return outer;
    }

    private void findSubs(int indx, int nums[], ArrayList<Integer> subset){
        outer.add(subset);

        for (int i =indx; i<nums.length; i++){
            subset.add(nums[i]);
            findSubs(i+1, nums, new ArrayList<>(subset));
            subset.remove(subset.size()-1);

        }
    }
    public static void main(String[] args) {

    }
}
