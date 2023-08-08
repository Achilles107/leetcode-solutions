package graphs;

public class NumberofClosedIslands {
    public int closedIsland(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        // left edge
        for (int row=0; row<rowSize; row++) {
            if (grid[row][0] == 0) {
                findIslands(row, 0, grid, rowSize, colSize);
            }
        }
        // right edge
        for (int row=0; row<rowSize; row++) {
            if (grid[row][colSize-1] == 0) {
                findIslands(row, colSize-1, grid, rowSize, colSize);
            }
        }
        // top edge
        for (int col=0; col<colSize; col++) {
            if (grid[0][col] == 0) {
                findIslands(0, col, grid, rowSize, colSize);
            }
        }
        // bottom edge
        for (int col=0; col<colSize; col++) {
            if (grid[rowSize-1][col] == 0) {
                findIslands(rowSize-1, col, grid, rowSize, colSize);
            }
        }

        int noOfIslands = 0;
        // Finding closed islands
        for (int row=0; row<rowSize; row++) {
            for (int col=0; col <colSize; col++) {
                if (grid[row][col] == 0) {
                    findIslands(row, col, grid, rowSize, colSize);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    private void findIslands(int row, int col, int[][] grid, int rowSize, int colSize) {
        if (!canMove(row, col, rowSize, colSize) || grid[row][col] == 1) {
            return;
        }
        grid[row][col] = 1;
        findIslands(row-1, col, grid, rowSize, colSize);
        findIslands(row+1, col, grid, rowSize, colSize);
        findIslands(row, col-1, grid, rowSize, colSize);
        findIslands(row, col+1, grid, rowSize, colSize);
    }

    private boolean canMove(int row, int col, int rowSize, int colSize) {
        return (row >=0 && row < rowSize) && (col >=0 && col < colSize);
    }
    public static void main(String[] args) {

    }
}
