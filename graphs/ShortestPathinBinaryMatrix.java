package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int dimenSize = grid.length;
        if (grid[0][0] == 1) return -1;
        if (grid[dimenSize-1][dimenSize-1] == 1) return -1;
        boolean[][] visited = new boolean[dimenSize][dimenSize];
        return calDistance(grid, dimenSize, visited);
    }

    private boolean canMove(int x, int y, int dimenSize) {
        return (x>=0 && x<dimenSize) && (y>=0 && y< dimenSize);
    }

    private int calDistance(int[][] grid, int dimenSize, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int distance = 0;

        int[] rowDir = {0,0,1,-1, 1, -1, 1, -1};
        int[] colDir = {1,-1,0,0, -1, 1, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance += 1;

            for (int i=0; i<size; i++) {

                int[] currCell = queue.poll();
                int currX = currCell[0];
                int currY = currCell[1];

                for (int j =0; j< rowDir.length; j++) {
                    int nextX = currX + rowDir[j];
                    int nextY = currY + colDir[j];
                    if (nextX == dimenSize-1 && nextY == dimenSize-1) return distance + 1;
                    if (canMove(nextX, nextY, dimenSize) && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
