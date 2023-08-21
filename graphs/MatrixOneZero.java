package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixOneZero {
    public int[][] updateMatrix(int[][] mat) {
        int nrows = mat.length;
        int ncols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int row=0; row<nrows; row++) {
            for (int col=0; col<ncols; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new int[]{row, col});
                }
                else {
                    mat[row][col] = -1;
                }
            }
        }

        getDistances(mat, queue, nrows, ncols);
        return mat;
    }

    private void getDistances(int[][] mat, Queue<int[]> queue, int nrows, int ncols) {
        int sideways[] = {1, -1, 0, 0};
        int vertical[] = {0, 0, 1, -1};
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            distance += 1;
            for (int i =0; i<size; i++) {
                int[] currNode = queue.poll();
                int currRow = currNode[0];
                int currCol = currNode[1];

                for (int j =0; j<4; j++) {
                    int nextRow = currRow + sideways[j];
                    int nextCol = currCol + vertical[j];
                    if (canMove(nextRow, nextCol, nrows, ncols) && mat[nextRow][nextCol] == -1) {
                        mat[nextRow][nextCol] = distance;
                        //distances[nextRow][nextCol] = distance;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }

            }
        }
    }

    private boolean canMove(int row, int col, int nrows, int ncols) {
        return (row >=0 && row < nrows) && (col>=0 && col <ncols);
    }
    public static void main(String[] args) {

    }
}
