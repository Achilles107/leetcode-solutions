package graphs.practice;

import java.util.*;

public class FindTheCheapestRoute {

    private Map<Integer, List<int[]>> createGraph(int flights[][], int n){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i =0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int flight[]: flights){
            int src = flight[0];
            int dest = flight[1];
            int price = flight[2];
            graph.get(src).add(new int[]{dest, price});
        }

        return graph;
    }

    private void bfs(Map<Integer, List<int[]>> graph, int src, int dest, Map<Integer, Integer> cheapestRoute) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> cheapestRoute.get(a) - cheapestRoute.get(b));
        Set<Integer> seen = new TreeSet<>();
        cheapestRoute.put(src, 0);
        seen.add(src);
        queue.add(src);
        while (!queue.isEmpty()) {
            int currPort = queue.poll();
            if (dest == currPort)
                return;
            List<int[]> connectedPorts = graph.get(currPort);
            //System.out.println(currPort);
            for (int[] port : connectedPorts) {
                int des = port[0];
                int price = port[1];
                int cheapestPrice = Math.min(cheapestRoute.get(des), cheapestRoute.get(currPort) + price);
                cheapestRoute.put(des, cheapestPrice);
                if (!seen.contains(des)) {
                    queue.add(des);
                    seen.add(des);
                }
            }
        }
    }

    private int cheapestFlight(int flights[][], int src, int dest, int noOfFlights){
        Map<Integer, List<int[]>> graph = createGraph(flights, noOfFlights);
        Map<Integer, Integer> cheapestRoute = new HashMap<>();
        for (int i=0; i<noOfFlights; i++){
            cheapestRoute.put(i, Integer.MAX_VALUE);
        }
        bfs(graph, src, dest, cheapestRoute);
        return cheapestRoute.get(dest);
    }
    public static void main(String[] args) {
        int flights[][] = {{0,1,200}, {0,2,100}, {0,3,7000}, {1,4,400}, {1,5,4000}, {1,3,2000},
                {2,1,300}, {2,6,2500}, {2,7,6500},{4,8,1500},{4,5,5000}, {3,6,100},{3,7,1000},
                {6,9,2000}, {8,3,50}, {5,10,200}, {7,10,100}, {9,10,150}};
        int noOfFlights = 11;
        //int flights[][] = {{0,1,1000}, {0,2,200}, {2,1,300}};
        System.out.println(new FindTheCheapestRoute().cheapestFlight(flights, 0, 9, noOfFlights));
    }
}
