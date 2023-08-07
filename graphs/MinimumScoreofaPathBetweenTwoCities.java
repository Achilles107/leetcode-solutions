package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 19:21 - 19:30
public class MinimumScoreofaPathBetweenTwoCities {
    private int minCost = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> roadsConnection = new HashMap<>();
        for (int road=1; road<=n; road++) {
            roadsConnection.put(road, new ArrayList<>());
        }
        boolean visited[] = new boolean[n+1];
        for (int road[]: roads) {
            int city1 = road[0];
            int city2 = road[1];
            int cost = road[2];
            roadsConnection.get(city1).add(new int[]{city2, cost});
            roadsConnection.get(city2).add(new int[]{city1, cost});
        }
        findMinimum(1, roadsConnection, visited);
        return this.minCost;
    }

    private void findMinimum(int currCity, Map<Integer, List<int[]>> connections, boolean visited[]) {
        if (visited[currCity])
            return;
        visited[currCity] = true;
        List<int[]> connectedCities = connections.get(currCity);
        for (int[] cities: connectedCities) {
            int nextCity = cities[0];
            int costOfMoving = cities[1];
            minCost = Math.min(minCost, costOfMoving);
            findMinimum(nextCity, connections, visited);
        }
    }
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println(new MinimumScoreofaPathBetweenTwoCities().minScore(n, roads));
    }
}
