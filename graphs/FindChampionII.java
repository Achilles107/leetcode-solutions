package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindChampionII {

    private HashMap<Integer, List<Integer>> createGraph(int[][] edges, int n) {
        if (n < 1)
            return null;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int edge[]: edges) {
            int winner = edge[0];
            int looser = edge[1];

            graph.get(winner).add(looser);
        }
        return graph;
    }

    public int findChampion(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = createGraph(edges, n);
        boolean[] visited = new boolean[n];

        for (int winner: graph.keySet()) {
            List<Integer> loosers = graph.get(winner);
            for (int looser: loosers) {
                visited[looser] = true;
            }
        }
        int winner = -1;
        int numberOfWinners = 0;
        for (int i =0; i<n; i++) {
            if (!visited[i]){
                winner = i;
                numberOfWinners++;
            }
            if (numberOfWinners>1)
                return -1;
        }
        return winner;
    }
    public static void main(String[] args) {

    }
}
