package tree;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {

    Map<Integer, Integer> sumCount = new HashMap<>();
    private int findCurrSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + findCurrSum(root.left) + findCurrSum(root.right);
        sumCount.put(sum, sumCount.getOrDefault(sum, 0)+1);
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        findCurrSum(root);
        System.out.println(sumCount);
        int max_len = 1;
        int count = 0;
        for (Integer key: sumCount.keySet()) {
            if (max_len < sumCount.get(key)) {
                max_len = sumCount.get(key);
            }

        }

        if (max_len == 1) {
            int[] result = new int[sumCount.keySet().size()];
            int i =0;
            for (Integer key: sumCount.keySet()) {
                result[i] = key;
                i++;
            }
            return result;
        }
        for (Integer key: sumCount.keySet()) {
            if (max_len == sumCount.get(key)) {
                count++;
            }

        }
        int res[] = new int[count];
        int i =0;
        for (Integer key: sumCount.keySet()) {
            if (sumCount.get(key) == max_len) {
                res[i] = key;
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
