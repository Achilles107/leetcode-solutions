package graphs.algos;

import java.util.*;

public class Prims {
    public static void main(String[] args) {
        int[][] array = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
        Prims prims = new Prims();
        System.out.println(prims.minCostConnectPoints(array));
    }

    private List<List<int[]>> calDistances(int arr[][]) {
        List<List<int[]>> distances = new ArrayList<>();
        int n = arr.length;
        for (int i =0; i<n; i++) {
            distances.add(new ArrayList<>());
        }
        for (int node=0; node<arr.length; node++) {
            for (int nextNode=0; node != nextNode && nextNode < arr.length; nextNode++) {
                int distance = Math.abs(arr[node][0] - arr[nextNode][0]) + Math.abs(arr[node][1] - arr[nextNode][1]);
                distances.get(node).add(new int[]{nextNode, distance});
                distances.get(nextNode).add(new int[]{node, distance});
            }
        }
        return distances;

    }
    public int minCostConnectPoints(int[][] array) {
        List<List<int[]>> distances = calDistances(array);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> seen = new TreeSet<>();
        queue.add(new int[]{0,0});
        int edges = 0;
        int minCost = 0;
        while (edges < array.length && !queue.isEmpty()) {
            int[] leastVal = queue.poll();
            int currVal = leastVal[0];
            int weight = leastVal[1];
            if (seen.contains(currVal))
                continue;
            seen.add(currVal);
            minCost += weight;
            edges++;
            List<int[]> neighbours = distances.get(currVal);
            for (int[] neighbour : neighbours) {
                int distance = neighbour[1];
                int nextNode = neighbour[0];
                if (!seen.contains(nextNode)) {
                    queue.add(new int[]{nextNode, distance});
                }

            }
        }
        return minCost;
    }
}
