package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindtheSafestPathinaGrid {

    private boolean noTheif = true;
    private boolean canMove(int nx, int ny, int n) {
        return (nx >= 0 && nx < n) && (ny >= 0 && ny < n);
    }

    private void findDistances(List<List<Integer>> grid, int n) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i =0; i<n; i++) {
            for (int j =0; j<n; j++) {
                if (grid.get(i).get(j) == 1) {
                    this.noTheif = false;
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        int steps = 1;
        while (!queue.isEmpty()) {
                int[] currBlk = queue.poll();
                int currX = currBlk[0];
                int currY = currBlk[1];

                for (int j =0; j<dirY.length; j++) {
                    int nextX = currX + dirX[j];
                    int nextY = currY + dirY[j];

                    if (canMove(nextX, nextY, n) && grid.get(nextX).get(nextY) == 0) {
                        grid.get(nextX).set(nextY, grid.get(currX).get(currY) + 1);
                        queue.add(new int[] {nextX, nextY});
                    }
                }
        }
    }

    private int findSafestDist(List<List<Integer>> grid, int n) {
        PriorityQueue<int[]> maxFirst = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        boolean[][] seen = new boolean[n][n];
        maxFirst.add(new int[]{0, 0, grid.get(0).get(0)});

        int safest = Integer.MAX_VALUE;

        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};
        while (!maxFirst.isEmpty()) {
            int[] currBlk = maxFirst.poll();
            int currX = currBlk[0];
            int currY = currBlk[1];
            int currVal = currBlk[2];

            safest = Math.min(safest, currVal);
            seen[currX][currY] = true;
            if (currX == n-1 && currY == n-1)
                break;
            for (int i =0; i<4; i++) {
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];

                if (canMove(nextX, nextY, n) && !seen[nextX][nextY]) {
                    maxFirst.add(new int[]{nextX,nextY, grid.get(nextX).get(nextY)});
                }
            }
        }
        return safest - 1;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1)
            return 0;
        findDistances(grid, n);
        if (noTheif)
            return 0;

        return findSafestDist(grid, n);

    }

    public static void main(String[] args) {

    }
}
