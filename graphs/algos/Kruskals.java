package graphs.algos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskals {

    class Union {
        private int[] parent;
        private int[] rank;

        Union(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int node = 0; node < size; node++) {
                parent[node] = node;
                rank[node] = 1;
            }
        }

        public int find(int node) {
            if (node != parent[node]) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            if (parent1 == parent2)
                return false;
            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
            } else if (rank[parent2] > rank[parent1]) {
                parent[parent1] = parent2;
            } else {
                parent[parent2] = parent1;
                rank[parent1] += 1;
            }
            return true;
        }
    }

    private ArrayList<int[]> calculateDist(int[][] array) {
        ArrayList<int[]> distances = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int distance = Math.abs(array[i][0] - array[j][0]) + Math.abs(array[i][1] - array[j][1]);
                distances.add(new int[]{i, j, distance});
            }
        }
        return distances;
    }

    private int minumumDistance = 0;

    private void formMST(ArrayList<int[]> distances, int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int[] distance : distances) {
            queue.add(distance);
        }
        int edges = 0;
        Union union = new Union(n);
        while (!queue.isEmpty() && edges < n-1) {
            int currEdge[] = queue.poll();
            if (union.union(currEdge[0], currEdge[1])) {
                minumumDistance += currEdge[2];
                edges++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> distances = calculateDist(points);
//        for (int dis[]: distances){
//            System.out.println(dis[0] +" "+dis[1]+" "+dis[2]);
//        }
        formMST(distances, points.length);
        return minumumDistance;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        Kruskals main = new Kruskals();
        System.out.println(main.minCostConnectPoints(array));
    }
}
