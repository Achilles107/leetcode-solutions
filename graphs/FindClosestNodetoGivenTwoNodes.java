package graphs;

import java.util.*;

public class FindClosestNodetoGivenTwoNodes {

    private final int MAX_VALUE = 1000001;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int numberOfNodes = edges.length;
        Map<Integer, List<Integer>> connections = getConnection(numberOfNodes, edges);
        int distances1[] = new int[numberOfNodes];
        Arrays.fill(distances1, MAX_VALUE);
        updateDistance(distances1, connections, node1);

        int distances2[] = new int[numberOfNodes];
        Arrays.fill(distances2, MAX_VALUE);

        updateDistance(distances2, connections, node2);

        int minDistance = Integer.MAX_VALUE;
        int closest = -1;
        for (int node=0; node<numberOfNodes; node++) {
            if (minDistance > Math.max(distances1[node], distances2[node])){
                minDistance = Math.max(distances1[node], distances2[node]);
                closest = node;
            }
        }
        return minDistance >= MAX_VALUE ? -1 : closest;
    }

    private void updateDistance(int[] distances, Map<Integer, List<Integer>> connections, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new TreeSet<>();

        queue.add(startNode);
        seen.add(startNode);
        distances[startNode] = 0;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            while (size-->0) {
                int currNode = queue.poll();
                List<Integer> neighbours = connections.get(currNode);
                for (int neighbour: neighbours) {
                    if (!seen.contains(neighbour)) {
                        seen.add(neighbour);
                        distances[neighbour] = level;
                        queue.add(neighbour);
                    }
                }
            }
        }
    }

    private Map<Integer, List<Integer>> getConnection(int numberOfNodes, int[] edges) {
        Map<Integer, List<Integer>> connection = new HashMap<>();
        for (int node=0; node< numberOfNodes; node++) {
            if (!connection.containsKey(node))
                connection.put(node, new ArrayList<>());
            if (edges[node] != -1)
                connection.get(node).add(edges[node]);
        }
        return connection;
    }
    public static void main(String[] args) {

    }
}
