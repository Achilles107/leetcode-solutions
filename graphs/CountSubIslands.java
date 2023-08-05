package graphs;

// 20:51 - 21:04
public class CountSubIslands {

    private boolean isSubset = true;

    private boolean canMove(int row, int col, int rowSize, int colSize) {
        return (row >= 0 && row < rowSize) && (col >= 0 && col < colSize);
    }

    private void findSubsets(int row, int col, int[][] grid1, int[][] grid2, int rowSize, int colSize) {
        if (!canMove(row, col, rowSize, colSize))
            return;
        if (grid2[row][col] == 0)
            return;
        if (grid2[row][col] == 2)
            return;
        if (grid2[row][col] != grid1[row][col]) {
            isSubset = false;
            return;
        }
        grid2[row][col] = 2;
        findSubsets(row - 1, col, grid1, grid2, rowSize, colSize);
        findSubsets(row + 1, col, grid1, grid2, rowSize, colSize);
        findSubsets(row, col - 1, grid1, grid2, rowSize, colSize);
        findSubsets(row, col + 1, grid1, grid2, rowSize, colSize);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rowSize = grid1.length;
        int colSize = grid1[0].length;
        int noOfSubsets = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                int srcBlock = grid2[row][col];
                int destBlock = grid1[row][col];
                if (srcBlock == 1 && destBlock == srcBlock) {
                    isSubset = true;
                    findSubsets(row, col, grid1, grid2, rowSize, colSize);
                    if (isSubset) {
                        noOfSubsets++;
                    }
                }
            }
        }
        return noOfSubsets;
    }

    public static void main(String[] args) {

    }
}
