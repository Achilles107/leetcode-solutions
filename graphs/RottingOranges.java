package graphs;

import java.util.*;

public class RottingOranges {

    private Set<Integer> seen = new TreeSet<>();

    private HashMap<Integer, List<Integer>> makeGraph(int grid[][]){
        int nodeNames = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> noOranges = new ArrayList<>();
        for (int i =0; i<grid.length*grid[0].length; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] != 0) {
                    if (j-1 >= 0 && grid[i][j-1] != 0){
                        graph.get(nodeNames).add(nodeNames-1);
                    }
                    if (i-1 >= 0 && grid[i-1][j] != 0){
                        graph.get(nodeNames).add(nodeNames - grid[i].length);
                    }
                    if (j+1 < grid[i].length && grid[i][j+1] != 0){
                        graph.get(nodeNames).add(nodeNames+1);
                    }
                    if (i+1 < grid.length && grid[i+1][j] != 0){
                        graph.get(nodeNames).add(nodeNames + grid[i].length);
                    }
                }
                else {
                    noOranges.add(nodeNames);
                }
                nodeNames++;
            }
        }
        for (Integer key: noOranges){
            if (graph.get(key).isEmpty()){
                graph.remove(key);
            }
        }
        return graph;
    }

    public int orangesRotting(int[][] grid) {
        int nodeNames = 0;
        List<Integer> rottenOranges = new ArrayList<>();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 2){
                    rottenOranges.add(nodeNames);
                }
                nodeNames++;
            }
        }

        HashMap<Integer, List<Integer>> graph = makeGraph(grid);
        int minutes = bfs(rottenOranges, graph);
        if (seen.size() != graph.keySet().size())
            return -1;
        return minutes;
    }

    private int bfs(List<Integer> rottenOranges, HashMap<Integer, List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();

        for (int orangeId: rottenOranges){
            queue.add(orangeId);
            seen.add(orangeId);
        }
        int minutes = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (seen.size() == graph.keySet().size())
                break;
            for (int i =0; i<size; i++){
                int currOrange = queue.poll();
                for (int orange: graph.get(currOrange)){
                    if (!seen.contains(orange)){
                        queue.add(orange);
                        seen.add(orange);
                    }
                }
            }
            minutes++;
        }
        return minutes;
    }

    public static void main(String[] args) {
        int grid[][]= {{2,1,1},{0,1,1}};
        System.out.println(new RottingOranges().orangesRotting(grid));
    }
}
