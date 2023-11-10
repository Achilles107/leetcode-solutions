package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPathSum {

    private int shortestPath(boolean visited[][], int[][] grid, int m, int n) {
        int distances[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minFirst = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        minFirst.add(new int[]{0, 0, grid[0][0]});
        distances[0][0] = grid[0][0];
        visited[0][0] = true;


        while (!minFirst.isEmpty()) {
            int currentGrid[] = minFirst.poll();
            int currentX = currentGrid[0];
            int currentY = currentGrid[1];
            visited[currentX][currentY] = true;
            if (currentX == m-1 && currentY == n-1)
                return distances[currentX][currentY];
            // add next grids
            int nextY = currentY + 1;
            int nextX = currentX + 1;

            if (nextX < m) {
                if (!visited[nextX][currentY] && distances[nextX][currentY] > distances[currentX][currentY] + grid[nextX][currentY]) {
                    distances[nextX][currentY] = Math.min(distances[nextX][currentY], distances[currentX][currentY] + grid[nextX][currentY]);
                    minFirst.add(new int[]{nextX, currentY, distances[nextX][currentY]});

                }


            }
            if (nextY < n) {
                if (!visited[currentX][nextY] && distances[currentX][nextY] > distances[currentX][currentY] + grid[currentX][nextY]) {
                    distances[currentX][nextY] = Math.min(distances[currentX][nextY], distances[currentX][currentY] + grid[currentX][nextY]);
                    minFirst.add(new int[]{currentX, nextY, distances[currentX][nextY]});

                }


            }
        }
        return distances[m-1][n-1];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        int minPath = shortestPath(visited, grid, m, n);
        return minPath;
    }
    public static void main(String[] args) {
        int grid[][] = {
                {1,2,3},{4,5,6}
        };
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }
}
