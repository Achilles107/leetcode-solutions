package backtracking;

import java.util.ArrayList;
import java.util.List;
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private void trace(List<Integer> currList, int[] combinations, int target, int sum, int start, int n){
        if (sum == target){
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        if (sum > target)
            return;
        for (int i = start; i<n; i++){
            if (sum <= target){
                currList.add(combinations[i]);
                sum += combinations[i];
                trace(currList, combinations, target, sum, i, n);
                sum -= combinations[i];
                currList.remove(currList.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        trace(new ArrayList<Integer>(), candidates, target, 0, 0, candidates.length);
        return result;
    }
    public static void main(String[] args) {
        int cand[] = {2};
        System.out.println(new CombinationSum().combinationSum(cand, 1));
    }
}
