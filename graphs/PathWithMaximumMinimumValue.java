package graphs;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
    private boolean canMove(int currX, int currY, int m, int n) {
        return (currX >= 0 && currX < m) && (currY >= 0 && currY < n);
    }

    private int findMaxScore(int[][] grid, int m, int n, boolean[][] seen) {
        PriorityQueue<int[]> maxFirst = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        maxFirst.add(new int[]{0, 0, grid[0][0]});
        //seen[0][0] = true;
        int maxScore = Integer.MAX_VALUE;

        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        while (!maxFirst.isEmpty()) {
            int[] currBlk = maxFirst.poll();
            int currX = currBlk[0];
            int currY = currBlk[1];
            int currVal = currBlk[2];

            seen[currX][currY] = true;

            maxScore = Math.min(maxScore, currVal);
            if (currX == m - 1 && currY == n - 1) {
                return maxScore;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];
                if (canMove(nextX, nextY, m, n) && !seen[nextX][nextY]) {
                    int nextVal = grid[nextX][nextY];
                    maxFirst.add(new int[]{nextX, nextY, nextVal});
                }
            }

        }
        return maxScore;
    }

    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] seen = new boolean[m][n];
        return findMaxScore(grid, m, n, seen);
    }
}
