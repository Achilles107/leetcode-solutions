package graphs;

// 18:50 to 19:10

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class SwiminRisingWater {
    public int swimInWater(int[][] grid) {
        int size = grid.length;
        PriorityQueue<Integer> nodeQueue = new PriorityQueue<>((a,b) -> Integer.compare(grid[a / size][a % size], grid[b / size][b % size]));
        int moveRow[] = {1,-1, 0, 0};
        int moveCol[] = {0,0, 1, -1};
        Set<Integer> seen = new TreeSet<>();
        nodeQueue.add(0);
        seen.add(0);
        int time = 0;

        while (!nodeQueue.isEmpty()) {
            int currNode = nodeQueue.poll();
            int row = currNode / size;
            int col = currNode % size;
            time = Math.max(time, grid[row][col]);
            if (row == size-1 && col == size-1)
                return time;

            for (int move =0; move<moveRow.length; move++) {
                int movingRow = row + moveRow[move];
                int movingCol = col + moveCol[move];
                int movingNode = (movingRow * size) + movingCol;
                if (canMove(movingRow, movingCol, movingNode, size) && !seen.contains(movingNode)) {
                    nodeQueue.add(movingNode);
                    seen.add(movingNode);
                }
            }
        }
        return time;
    }

    private boolean canMove(int movingRow, int movingCol, int movingNode, int size) {
        return (movingRow >= 0 && movingRow < size) && (movingCol >= 0 && movingCol < size) && movingNode < size*size;
    }
    public static void main(String[] args) {

    }
}
