package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheapestFlightsWithinKStops {

    class GraphNode {

        public int dest;
        public int price;
        public GraphNode(int dest, int price){
            this.dest = dest;
            this.price = price;
        }
    }

    private int cheapestPrice = Integer.MAX_VALUE;
    private boolean foundIt = false;

    private void dfs(Map<Integer, List<int[]>> connections, int price, int src, int dest, int k, boolean visited[]){
        if (src == dest) {
            cheapestPrice = Math.min(cheapestPrice, price);
            foundIt = true;
            return;
        }
        if (k < 0)
            return;
        if (visited[src])
            return;
        if (cheapestPrice < price)
            return;
        visited[src] = true;
        List<int[]> stops = connections.get(src);
        for (int stop =0; stop <stops.size(); stop++){
            price += stops.get(stop)[1];
            k -= 1;
            dfs(connections, price, stops.get(stop)[0], dest, k, visited);
            k += 1;
            price -= stops.get(stop)[1];
        }
        visited[src] = false;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> flightConnection = new HashMap<>();
        for (int flight=0; flight<n; flight++){
            flightConnection.put(flight, new ArrayList<>());
        }
        for (int[] routes: flights){
            flightConnection.get(routes[0]).add(new int[]{routes[1], routes[2]});
        }

        boolean[] visited = new boolean[n];
        dfs(flightConnection, 0, src, dst, k, visited);
        return foundIt ? this.cheapestPrice : -1;
    }
    public static void main(String[] args) {


        int n = 3;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src = 0;
        int dst = 2;
        int k = 1;

        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, k));
    }
}
