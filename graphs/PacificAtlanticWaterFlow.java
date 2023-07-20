package graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean pacific[][] = new boolean[heights.length][heights[0].length];
        boolean atlantic[][] = new boolean[heights.length][heights[0].length];

        // for pacific first
        for (int j =0; j<heights[0].length; j++){
            dfs(heights, 0, j, pacific, -1);
        }
        for (int j =0; j<heights[0].length; j++){
            dfs(heights, heights.length-1, j, atlantic, -1);
        }
        for (int i=0; i<heights.length; i++){
            dfs(heights, i, 0, pacific, -1);
        }
        for (int i=0; i<heights.length; i++){
            dfs(heights, i, heights[0].length-1, atlantic, -1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i =0; i< pacific.length; i++){
            for (int j =0; j<pacific[i].length; j++){
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> coords = new ArrayList<>();
                    coords.add(i);
                    coords.add(j);
                    result.add(coords);
                }
            }
        }
        return result;
    }

    private boolean move(int i, int j, int[][] heights) {
        return (i>=0 && i<heights.length && j>=0 && j<heights[0].length);
    }
    private void dfs(int[][] heights, int i, int j, boolean[][] ocean, int parent) {
        if (!move(i, j, heights))
            return;
        if (ocean[i][j])
            return;
        if (heights[i][j] < parent)
            return;
        ocean[i][j] = true;
        dfs(heights, i, j-1, ocean, heights[i][j]);
        dfs(heights, i, j+1, ocean, heights[i][j]);
        dfs(heights, i-1, j, ocean, heights[i][j]);
        dfs(heights, i+1, j, ocean, heights[i][j]);
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(heights));
    }
}
