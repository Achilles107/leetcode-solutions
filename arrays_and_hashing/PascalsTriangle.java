package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            if (i == 0) {
                rows.add(1);
                triangle.add(rows);
                continue;
            }
            if (i == 1) {
                // add end points
                rows.add(1);
                rows.add(1);
                triangle.add(rows);
                continue;
            }
            // get the latest row
            List<Integer> lastRow = triangle.get(triangle.size() - 1);
            int sum = 0;
            for (int row : lastRow) {
                sum += row;
                rows.add(sum);
                sum = row;
            }
            rows.add(1);
            triangle.add(rows);
        }
        return triangle;
    }
}
