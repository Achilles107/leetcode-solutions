package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsII {
    private final List<List<Integer>> outer = new ArrayList<>();
    Map<String, List<Integer>> maps = new HashMap<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        findSubs(0, nums, new ArrayList<>(), "");
        return outer;
    }

    private void findSubs(int indx, int nums[], ArrayList<Integer> subset, String str){
        if (!str.equals("") && !maps.containsKey(str)) {
            outer.add(subset);
            maps.put(str, new ArrayList<>(subset));
        }


        for (int i =indx; i<nums.length; i++){
            subset.add(nums[i]);
            str += nums[i];
            findSubs(i+1, nums, new ArrayList<>(subset), str);
            subset.remove(subset.size()-1);
            str = str.substring(0, str.length()-1);

        }
    }
    public static void main(String[] args) {

    }
}
