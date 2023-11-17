package backtracking;

import java.util.Arrays;

public class RatMaze {
    boolean solveMaze(int maze[][]){
        int sol[][] = new int[maze.length][maze.length];
        int x = 0;
        int y = 0;
        if (solve(maze, sol, x, y, maze.length))
            return true;
        return false;

    }

    private boolean isSafe(int x, int y, int maze[][], int n){
        return x >= 0 && x < n && y>=0 && y < n && maze[x][y] == 1;
    }

    private boolean solve(int[][] maze, int[][] sol, int x, int y, int n) {

        if (x == n-1 && y == n-1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(x,y,maze,n)) {
            if (sol[x][y] == 1)
                return false;
            sol[x][y] = 1;

            if (solve(maze, sol, x+1, y, n))
                return true;
            if (solve(maze, sol, x, y+1, n))
                return true;
            sol[x][y] = 0;

            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        RatMaze rat = new RatMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int N = maze.length;
        boolean is = rat.solveMaze(maze);
        System.out.println(is);
    }
}
