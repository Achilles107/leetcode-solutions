package graphs;

import java.util.*;

public class CheapestFlightsWithinKStopsBFS {
    private Map<Integer, Integer> prices = new HashMap<>();
    private Map<Integer, List<int[]>> createGraph(int numberOfFlights, int[][] flights) {
        Map<Integer, List<int[]>> routes = new HashMap<>();
        for (int flightIds=0; flightIds<numberOfFlights; flightIds++){
            routes.put(flightIds, new ArrayList<>());
            prices.put(flightIds, Integer.MAX_VALUE);
        }
        for (int[] flightIds: flights) {
            routes.get(flightIds[0]).add(new int[]{flightIds[1], flightIds[2]});
        }
        return routes;
    }

    private void checkingRoutes(int[][] flights, int src, int k, Map<Integer, List<int[]>> routes) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        prices.put(src, 0);
        int stops = 0;
        while (stops <= k && !queue.isEmpty()) {
            int size = queue.size();
            for (int i =0; i<size; i++) {
                int[] curStop = queue.poll();
                int currStop = curStop[0];
                int dist = curStop[1];
                List<int[]> connStops = routes.get(currStop);
                for (int[] connStop: connStops) {
                    if (connStop[1] + dist >= prices.get(connStop[0]))
                        continue;
                    prices.put(connStop[0], Math.min(prices.get(connStop[0]), dist + connStop[1]));
                    queue.add(new int[]{connStop[0], prices.get(connStop[0])});
                }
            }
            stops++;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> routes = createGraph(n, flights);
        checkingRoutes(flights, src, k, routes);
        return prices.get(dst) == Integer.MAX_VALUE ? -1 : prices.get(dst);
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(new CheapestFlightsWithinKStopsBFS().findCheapestPrice(n, flights, src, dst, k));

    }
}
