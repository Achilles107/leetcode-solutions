package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationSumIII {

    List<List<Integer>> result;

    private void trace(int target, int size, List<Integer> innerList, int currSum, int depth, int start, HashMap<Integer, Integer> usedNumbers) {
        if (currSum == target) {
            if (innerList.size() == size) {
                result.add(new ArrayList<>(innerList));
            }
        }
        if (currSum > target)
            return;
        if (depth > size)
            return;
        for (int i = start; i < 10; i++) {
            if (usedNumbers.get(i) == 1) {
                currSum += i;
                innerList.add(i);
                usedNumbers.put(i, usedNumbers.get(i) - 1);
                depth += 1;
                trace(target, size, innerList, currSum, depth, i, usedNumbers);
                currSum -= i;
                usedNumbers.put(i, usedNumbers.get(i) + 1);
                depth -= 1;
                innerList.remove(innerList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.result = new ArrayList<>();
        HashMap<Integer, Integer> usedNumbers = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            usedNumbers.put(i, 1);
        }

        trace(n, k, new ArrayList<>(), 0, 0, 1, usedNumbers);
        return result;
    }
}
