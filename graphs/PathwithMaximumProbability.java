package graphs;

import javafx.util.Pair;

import java.util.*;

public class PathwithMaximumProbability {

    private Map<Integer, List<Pair<Integer, Double>>> createConnections(int n, int[][] edges, double[] succProb) {
        Map<Integer, List<Pair<Integer, Double>>> connection = new HashMap<>();

        for (int node =0; node<n; node++) {
            connection.put(node, new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            double probability = succProb[i];

            connection.get(src).add(new Pair<>(dest, probability));
            connection.get(dest).add(new Pair<>(src, probability));
        }

        return connection;
    }

    private void calculateProbability(Map<Integer, List<Pair<Integer, Double>>> connection, double[] totalProbabilities, int start, int end) {
        PriorityQueue<Pair<Integer, Double>> maxFirst = new PriorityQueue<>((b,a) -> Double.compare(a.getValue(), b.getValue()));
        Set<Integer> seen = new TreeSet<>();

        maxFirst.add(new Pair<>(start, 1.0));
        totalProbabilities[start] = 1;

        while (!maxFirst.isEmpty()) {
            Pair<Integer, Double> currNode = maxFirst.poll();
            int nodeValue = currNode.getKey();
            double nodeProb = currNode.getValue();

            List<Pair<Integer, Double>> neighbours = connection.get(nodeValue);
            for (Pair<Integer, Double> neighbour: neighbours) {
                int neighNode = neighbour.getKey();
                double neighProb = neighbour.getValue();
                double newProb = neighProb * nodeProb;
                if (totalProbabilities[neighNode] < newProb) {
                    totalProbabilities[neighNode] = newProb;
                    maxFirst.add(new Pair<>(neighNode, newProb));
                }
            }
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> connection = createConnections(n, edges, succProb);
        double[] totalProbabilities = new double[n];
        Arrays.fill(totalProbabilities, Double.MIN_VALUE);

        calculateProbability(connection, totalProbabilities, start_node, end_node);

        return totalProbabilities[end_node] == Double.MIN_VALUE ? 0 : totalProbabilities[end_node];
    }
    public static void main(String[] args) {

    }
}
