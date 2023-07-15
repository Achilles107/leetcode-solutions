package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WallsandGates {


    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };

        new WallsandGates().wallsAndGates(rooms);

        for (int i=0; i<rooms.length; i++){
            System.out.println();
            for (int j=0; j<rooms[i].length; j++){
                System.out.print(" "+rooms[i][j]);
            }
        }
    }

    public void wallsAndGates(int[][] rooms) {
        for (int i =0;i<rooms.length; i++){
            for (int j=0; j<rooms[i].length; j++){
                if (rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int distance) {
        if (i<0 || i>rooms.length-1 || j<0 || j>rooms[i].length-1 || rooms[i][j] <= distance && distance!=0)
            return;
        rooms[i][j] = distance;
        dfs(rooms, i, j-1, distance+1);
        dfs(rooms, i, j+1, distance+1);
        dfs(rooms, i-1, j, distance+1);
        dfs(rooms, i+1, j, distance+1);
    }
}
