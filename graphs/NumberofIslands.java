package graphs;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        for (int row =0; row< grid.length; row++){
            for (int col=0; col<grid[row].length; col++){
                if (grid[row][col] == '1'){
                    dfs(grid, row, col);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private boolean canMove(char[][] grid, int i, int j){
        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length);
    }
    private void dfs(char[][] grid, int i, int j){
        if (!canMove(grid,i,j))
            return;
        if (grid[i][j] != '1')
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
        }
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(new NumberofIslands().numIslands(grid));

    }
}
