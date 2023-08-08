package graphs;

// 22:29 - 22:43

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossibleBFS {

    public int maxDistance(int[][] grid) {
        int size = grid.length;
        Queue<int[]> coordinates = new LinkedList<>();
        boolean visited[][] = new boolean[size][size];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    visited[row][col] = true;
                    coordinates.add(new int[]{row, col});
                }
            }
        }
        int dirRow[] = {1, -1, 0, 0};
        int dirCol[] = {0, 0, 1, -1};
        int distance = -1;

        while (!coordinates.isEmpty()) {
            int currSize = coordinates.size();
            for (int currIdx = 0; currIdx < currSize; currIdx++) {
                int currNode[] = coordinates.poll();
                int row = currNode[0];
                int col = currNode[1];
                for (int i = 0; i < dirCol.length; i++) {
                    int currRow = row + dirRow[i];
                    int currCol = col + dirCol[i];
                    if (canMove(currRow, currCol, size) && !visited[currRow][currCol]) {
                        coordinates.add(new int[]{currRow, currCol});
                        visited[currRow][currCol] = true;
                    }
                }
            }
            distance += 1;
        }
        return distance == 0 ? -1 : distance;
    }

    private boolean canMove(int row, int col, int size) {
        return (row >= 0 && row < size) && (col >= 0 && col < size);
    }

    public static void main(String[] args) {

    }
}
