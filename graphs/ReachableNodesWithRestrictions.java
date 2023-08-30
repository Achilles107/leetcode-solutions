package graphs;

import java.util.*;

public class ReachableNodesWithRestrictions {
    private Map<Integer, List<Integer>>  makeConnections(int[][] edges, int n) {
        Map<Integer, List<Integer>> connections = new HashMap<>();
        for (int node=0; node<n; node++) {
            connections.put(node, new ArrayList<>());
        }

        for (int edge[]: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            connections.get(node1).add(node2);
            connections.get(node2).add(node1);
        }
        return connections;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> connections = makeConnections(edges, n); // get connections

        boolean[] isRestricted = new boolean[n];
        for (int node: restricted) {
            isRestricted[node] = true;
        }
        boolean[] visited = new boolean[n];
        visitNodesFromZero(connections, visited, isRestricted);
        int noOfVistedNodes = 0;
        for (boolean visit: visited) {
            if (visit)
                noOfVistedNodes++;
        }
        return noOfVistedNodes;
    }
    private void visitNodesFromZero(Map<Integer, List<Integer>> connections, boolean[] visited, boolean[] isRestricted) {
        Queue<Integer> queue = new LinkedList<>();

        // start from zero
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            List<Integer> neighbours = connections.get(currNode);

            for (int neighbour: neighbours) {
                if (!isRestricted[neighbour] && !visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
