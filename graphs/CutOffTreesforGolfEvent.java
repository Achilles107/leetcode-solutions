package graphs;

import java.util.*;

public class CutOffTreesforGolfEvent {
    private int nrows;
    private int ncols;

    private boolean canMove(int x, int y) {
        return (x >= 0 && x < nrows) && (y >= 0 && y < ncols);
    }

    private int distance(List<List<Integer>> forest, int x, int y, int dx, int dy) {

        boolean[][] seen = new boolean[nrows][ncols];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});

        seen[x][y] = true;
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {-1, 1, 0, 0};

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] currTree = queue.poll();
                int currX = currTree[0];
                int currY = currTree[1];

                if (currX == dx && currY == dy)
                    return dist;

                for (int i = 0; i < 4; i++) {
                    int nextX = currX + dirX[i];
                    int nextY = currY + dirY[i];

                    if (canMove(nextX, nextY) && !seen[nextX][nextY] && forest.get(nextX).get(nextY) >= 1) {
                        queue.add(new int[]{nextX, nextY});
                        seen[nextX][nextY] = true;
                    }
                }
            }
            dist += 1;
        }
        return -1;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        nrows = forest.size();
        ncols = forest.get(0).size();

        int[] start = {0, 0};

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {
                if (forest.get(i).get(j) <= 1)
                    continue;
                trees.add(new int[]{forest.get(i).get(j), i, j});
            }
        }

        Collections.sort(trees, (a, b) -> (a[0] - b[0]));

        int steps = 0;
        int x = 0, y = 0;
        for (int[] tree : trees) {
            int[] dest = new int[]{tree[1], tree[2]};

            int dist = distance(forest, x, y, dest[0], dest[1]);

            if (dist < 0)
                return -1;

            steps += dist;
            x = dest[0];
            y = dest[1];

        }
        return steps;
    }
}
