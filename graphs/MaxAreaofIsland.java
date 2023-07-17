package graphs;


public class MaxAreaofIsland {

    private int maxArea = 0;
    private int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i =0; i<grid.length; i++){
            for (int j =0; j<grid[i].length; j++){
                if (grid[i][j] == 1){
                    this.area = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private boolean move(int i, int j, int[][] grid){
        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length);
    }
    private void dfs(int[][] grid, int i, int j) {
        if (!move(i, j, grid))
            return;
        if (grid[i][j] != 1)
            return;
        if (grid[i][j] == 1){
            this.area++;
            grid[i][j] = 2;
        }
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(new MaxAreaofIsland().maxAreaOfIsland(grid));
    }
}
