package graphs;

import java.util.*;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int res[] = new int[2];
        List<Integer> nodes = new ArrayList<>();
        for (int i =0; i<edges.length; i++){
            if (!nodes.contains(edges[i][0]))
                nodes.add(edges[i][0]);
            if (!nodes.contains(edges[i][1]))
                nodes.add(edges[i][1]);
        }
        for (int i =0; i<nodes.size(); i++){
            graph.put(nodes.get(i), new ArrayList<>());
        }
        Set<Integer> visited = new TreeSet<>();
        for (int edge=0; edge<edges.length; edge++){
            graph.get(edges[edge][0]).add(edges[edge][1]);
            graph.get(edges[edge][1]).add(edges[edge][0]);
            visited.clear();
            if (!graph.get(edges[edge][0]).isEmpty() && !graph.get(edges[edge][1]).isEmpty() && connected(graph, edges[edge][0], edges[edge][1], visited)) {
                return edges[edge];
            }

        }
        return res;
    }

    private boolean connected(Map<Integer, List<Integer>> graph, int node1, int node2, Set<Integer> visited) {

        if (!visited.contains(node1)){
            visited.add(node1);
            if (node1 == node2)
                return true;
            for (int dests: graph.get(node1)) {
                if (connected(graph, dests, node2, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
