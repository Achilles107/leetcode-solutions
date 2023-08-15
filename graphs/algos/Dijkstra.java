package graphs.algos;

import java.util.*;

public class Dijkstra {

    private Map<Integer, List<int[]>> createGraph(int nodes[][]){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int edge[]: nodes){
            if (graph.containsKey(edge[0])){
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }
            else {
                graph.put(edge[0], new ArrayList<int[]>());
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }
            if (graph.containsKey(edge[1])){
                graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
            }
            else {
                graph.put(edge[1], new ArrayList<int[]>());
                graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
            }
        }
        return graph;
    }

    private void bfs(Map<Integer, List<int[]>> graph, int start, int end, Map<Integer, Integer> distances) {
        Set<Integer> seen = new TreeSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        distances.put(start, 0);
        queue.add(start);
        seen.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i =0; i<size; i++){
                int currNode = queue.poll();
                List<int[]> neighbours = graph.get(currNode);
                for (int neighbour[]: neighbours){
                    if (!seen.contains(neighbour[0])) {
                        queue.add(neighbour[0]);
                        seen.add(neighbour[0]);
                    }
                    distances.put(neighbour[0], Math.min(distances.get(neighbour[0]), distances.get(currNode) + neighbour[1]));
                }
                //seen.add(currNode);
            }
        }
    }
    private int shortestPath(Map<Integer, List<int[]>> graph, int start, int end) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (Integer key: graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }
        bfs(graph, start, end, distances);
        return distances.get(end);
    }
    public static void main(String[] args) {
        int[][] nodes = {{0,1,4},{1,2,8},{2,5,4},{5,6,2},{6,7,1},{0,7,8},{1,7,1},{7,8,7},{2,8,2},{6,8,4}};
        Dijkstra dijkstra = new Dijkstra();
        Map<Integer, List<int[]>> graph = dijkstra.createGraph(nodes);
        System.out.println(dijkstra.shortestPath(graph, 0, 7));

    }
}
