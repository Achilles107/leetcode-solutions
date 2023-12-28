package arrays_and_hashing;

import java.util.HashMap;
import java.util.HashSet;

public class EqualRowandColumnPairs {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> allRows = new HashMap<>();
        int gridLen = grid.length;

        for (int nums[]: grid) {
            StringBuilder rowString = new StringBuilder();
            for (int n: nums) {
                rowString.append(n+":");
            }
            allRows.put(rowString.toString(), allRows.getOrDefault(rowString.toString(), 0) + 1);
        }

        int numberOfPairs = 0;
        for (int i =0; i<gridLen; i++) {
            StringBuilder colStrings = new StringBuilder();
            for (int j =0; j<gridLen; j++) {
                colStrings.append(grid[j][i]+":");
            }
            if (allRows.containsKey(colStrings.toString())) {
                numberOfPairs += allRows.get(colStrings.toString());
            }
        }
        return numberOfPairs;
    }
}
