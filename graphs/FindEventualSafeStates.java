package graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    private int[][] graph;
    private int noOfNodes;

    private void markTerminalNodes(boolean safeNodes[]) {
        for (int node = 0; node < noOfNodes; node++) {
            if (graph[node].length == 0) {
                safeNodes[node] = true;
            }
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        this.noOfNodes = graph.length;
        boolean safeNodes[] = new boolean[noOfNodes];
        markTerminalNodes(safeNodes);

        boolean visited[] = new boolean[noOfNodes];
        for (int node = 0; node < noOfNodes; node++) {
            isSafe(node, graph, visited, safeNodes);
        }
        List<Integer> safeStates = new ArrayList<>();

        for (int node = 0; node < noOfNodes; node++) {
            if (safeNodes[node]) {
                safeStates.add(node);
            }
        }
        return safeStates;
    }

    private boolean isSafe(int node, int[][] graph, boolean[] visited, boolean[] safeNodes) {
        if (safeNodes[node])
            return true;
        if (visited[node]) {
            return false;
        }

        int[] children = graph[node];
        visited[node] = true;
        for (int child : children) {
            if (!isSafe(child, graph, visited, safeNodes)) {
                return false;
            }
        }
        safeNodes[node] = true;
        return true;
    }


    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
    }
}
