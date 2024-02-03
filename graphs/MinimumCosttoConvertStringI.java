package graphs;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumCosttoConvertStringI {
    private HashMap<String, Long> cost = new HashMap<>();

    private int[][] constructGraph(char[] original, char[] changed, int[] cost, int n) {
        int[][] graph = new int[26][26];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            int currVal = graph[original[i] - 'a'][changed[i] - 'a'];
            graph[original[i] - 'a'][changed[i] - 'a'] = Math.min(currVal, cost[i]);
        }

        return graph;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = constructGraph(original, changed, cost, cost.length);

        long minCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char src = source.charAt(i);
            char dest = target.charAt(i);
            if (src != dest) {
                long changedCost = changingCost(src, dest, graph);
                if (changedCost == -1)
                    return -1;
                minCost += changedCost;
            }
        }
        return minCost;
    }

    private long changingCost(char src, char dest, int[][] graph) {
        if (cost.containsKey(src + "-" + dest)) {
            return cost.get(src + "-" + dest);
        }

        PriorityQueue<Pair<Integer, Long>> minFirst = new PriorityQueue<>(
                (a, b) -> Long.compare(a.getValue(), b.getValue()));
        // boolean[][] seen = new boolean[graph.length][graph[0].length];

        long[] dist = new long[26];
        Arrays.fill(dist, Long.MAX_VALUE);

        minFirst.add(new Pair(src - 'a', 0L));
        dist[src - 'a'] = 0;
        // seen[src-'a'][src-'a'] = true;

        while (!minFirst.isEmpty()) {
            Pair<Integer, Long> currNode = minFirst.poll();
            int currChar = currNode.getKey();
            long currDist = currNode.getValue();

            if (currChar == dest - 'a') {
                cost.put(src + "-" + dest, dist[currChar]);
                return dist[currChar];
            }
            for (int i = 0; i < 26; i++) {
                if (dist[currChar] != Long.MAX_VALUE && graph[currChar][i] != Integer.MAX_VALUE
                        && dist[currChar] + graph[currChar][i] < dist[i]) {
                    dist[i] = dist[currChar] + graph[currChar][i];
                    minFirst.add(new Pair(i, dist[i]));
                }
            }
        }
        return -1;
    }
}
