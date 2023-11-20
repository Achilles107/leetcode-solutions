package graphs;

import java.util.*;

public class DesignGraphWithShortestPathCalculator {
    class Graph {

        int n;
        HashMap<Integer, List<int[]>> graph;

        public Graph(int n, int[][] edges) {
            this.n = n;
            this.graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            }
        }

        public void addEdge(int[] edge) {
            if (!this.graph.containsKey(edge[0])) {
                this.graph.put(edge[0], new ArrayList<>());
                this.n++;
            }
            this.graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            int[] minDist = new int[this.n];
            Arrays.fill(minDist, Integer.MAX_VALUE);
            return shortestPath(minDist, node1, node2);
        }

        private int shortestPath(int[] minDist, int node1, int node2) {
            PriorityQueue<int[]> minFirst = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            Set<Integer> seen = new TreeSet<>();
            minDist[node1] = 0;
            seen.add(node1);
            minFirst.add(new int[]{node1, 0});
            while (!minFirst.isEmpty()) {
                int[] current = minFirst.poll();
                int currentNode = current[0];
                int currentDist = current[1];
                if (currentNode == node2)
                    return minDist[currentNode];
                List<int[]> nextNodes = this.graph.get(currentNode);

                for (int[] next : nextNodes) {
                    int nextNode = next[0];
                    int nextDist = next[1];

                    if (!seen.contains(nextNode) && minDist[nextNode] > minDist[currentNode] + nextDist) {
                        seen.add(nextNode);
                        minDist[nextNode] = minDist[currentNode] + nextDist;
                        minFirst.add(new int[]{nextNode, minDist[nextNode]});
                    }
                }
            }
            return minDist[node2] == Integer.MAX_VALUE ? -1 : minDist[node2];
        }
    }

    public static void main(String[] args) {

    }
}
