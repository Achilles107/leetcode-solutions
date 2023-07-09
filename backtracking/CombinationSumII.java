package backtracking;

import java.util.*;

public class CombinationSumII {

    private List<List<Integer>> result = new ArrayList<>();

    private void trace(List<Integer> currList, HashMap<Integer, Integer> count, List<Integer> combinations, int target, int sum, int start, int n){
        if (sum == target){
            result.add(new ArrayList<>(currList));
        }
        if (sum > target)
            return;
        for (int i = start; i<n; i++){
                if (count.get(combinations.get(i)) > 0) {
                    currList.add(combinations.get(i));
                    sum += combinations.get(i);
                    count.put(combinations.get(i), count.get(combinations.get(i))-1);
                    trace(currList, count,combinations, target, sum, i, n);
                    sum -= combinations.get(i);
                    count.put(combinations.get(i), count.get(combinations.get(i))+1);
                    currList.remove(currList.size()-1);
                }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cands = new ArrayList<>();
        for (int i: candidates){
            if (!cands.contains(i)){
                cands.add(i);
            }
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i =0; i<candidates.length; i++){
            count.put(candidates[i], count.getOrDefault(candidates[i], 0)+1);
        }
        trace(new ArrayList<>(), count,cands, target, 0, 0, cands.size());
        return result;
    }
    public static void main(String[] args) {
        int cand[] = {2,5,1,1,2,3,3,3,1,2,2};
        int target = 5;
        System.out.println(new CombinationSumII().combinationSum2(cand, target));
    }
}
