package graphs;

public class IslandPerimeter {

    private int perimeter = 0;

    private boolean canMove(int i, int j, int nr, int nc) {
        return (i >= 0 && i < nr) && (j >=0 && j < nc);
    }
    private void walk(int i, int j, int grid[][], int nr, int nc) {
        if (!canMove(i,j, nr, nc)){
            this.perimeter += 1;
            return;
        }
        if (grid[i][j] == 0) {
            this.perimeter += 1;
            return;
        }
        if (grid[i][j] == 2) {
            return;
        }
        grid[i][j] = 2;
        walk(i-1, j, grid, nr, nc);
        walk(i+1, j, grid, nr, nc);
        walk(i, j-1, grid, nr, nc);
        walk(i, j+1, grid, nr, nc);
    }
    public int islandPerimeter(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i =0; i<grid.length; i++) {
            for (int j =0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    walk(i, j, grid, nr, nc);
                }
            }
        }
        return this.perimeter;
    }
    public static void main(String[] args) {

    }
}
