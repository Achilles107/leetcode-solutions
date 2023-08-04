package graphs;
// 19:14 - 19:23
public class NumberofEnclaves {

    private boolean canMove(int row, int col, int rowSize, int colSize) {
        return (row >= 0 && row < rowSize) && (col >= 0 && col < colSize);
    }
    private void changeAttachedOnes(int row, int col, int[][] grid, int rowSize, int colSize) {
        if (!canMove(row, col, rowSize, colSize) || grid[row][col] == 0)
            return;
        grid[row][col] = 0;

        changeAttachedOnes(row, col-1, grid, rowSize, colSize);
        changeAttachedOnes(row, col+1, grid, rowSize, colSize);
        changeAttachedOnes(row-1, col, grid, rowSize, colSize);
        changeAttachedOnes(row+1, col, grid, rowSize, colSize);
    }
    public int numEnclaves(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        // Top edge
        for (int col = 0; col < colSize; col++) {
            if (grid[0][col] == 1){
                changeAttachedOnes(0, col, grid, rowSize, colSize);
            }
        }

        // Bottom Edge
        for (int col = 0; col < colSize; col++) {
            if (grid[rowSize-1][col] == 1){
                changeAttachedOnes(rowSize-1, col, grid, rowSize, colSize);
            }
        }

        // Left Edge
        for (int row = 0; row < rowSize; row++) {
            if (grid[row][0] == 1){
                changeAttachedOnes(row, 0, grid, rowSize, colSize);
            }
        }

        // Right Edge
        for (int row = 0; row < rowSize; row++) {
            if (grid[row][colSize-1] == 1){
                changeAttachedOnes(row, colSize-1, grid, rowSize, colSize);
            }
        }

        int noOfEnclaves = 0;

        for (int row = 0; row < rowSize; row++) {
            for (int col =0; col < colSize; col++) {
                if (grid[row][col] == 1){
                    noOfEnclaves++;
                }
            }
        }
        return noOfEnclaves;
    }
    public static void main(String[] args) {

    }
}
