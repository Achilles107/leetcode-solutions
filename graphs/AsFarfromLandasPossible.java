package graphs;
//21:46 - 22:01
public class AsFarfromLandasPossible {

    private boolean canMove(int row, int col, int size) {
        return (row >=0 && row < size) && (col >=0 && col < size);
    }
    private void findNearestLand(int row, int col, int[][] grid, int size, int distance, boolean[][] visited) {
        if (!canMove(row, col, size))
            return;
        if (grid[row][col] < distance)
            return;
        grid[row][col] = Math.min(distance, grid[row][col]);

        findNearestLand(row-1, col, grid, size, distance+1, visited);
        findNearestLand(row+1, col, grid, size, distance+1, visited);
        findNearestLand(row, col-1, grid, size, distance+1, visited);
        findNearestLand(row, col+1, grid, size, distance+1, visited);

    }
    public int maxDistance(int[][] grid) {
        int size = grid.length;
        boolean visited[][] = new boolean[size][size];
        for (int row =0; row<size; row++) {
            for (int col =0; col<size; col++) {
                if (grid[row][col] == 0) {
                    grid[row][col] = Integer.MAX_VALUE;
                }
                else {
                    grid[row][col] = 0;
                }
            }
        }
        for (int row =0; row<size; row++) {
            for (int col =0; col<size; col++) {
                int block = grid[row][col];
                if (block == 0){
                    findNearestLand(row, col, grid, size, 0, visited);
                }
            }
        }

        int maxDistance = -1;
        for (int row =0; row<size; row++) {
            for (int col =0; col<size; col++) {
                if (grid[row][col] != Integer.MAX_VALUE && grid[row][col] != 0)
                    maxDistance = Math.max(maxDistance, grid[row][col]);
            }
        }
        return maxDistance;
    }
    public static void main(String[] args) {

    }
}
