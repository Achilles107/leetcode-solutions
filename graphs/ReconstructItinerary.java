package graphs;

import java.util.*;

public class ReconstructItinerary {

    private LinkedList<String> itinerary = new LinkedList<>();
    private Map<String, PriorityQueue<String>> createRoutes(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> routes = new HashMap<>();
        for (List<String> ticket: tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (!routes.containsKey(origin)) {
                routes.put(origin, new PriorityQueue<>());
            }
            routes.get(origin).add(dest);
        }
        return routes;
    }

    private  void createItinerary(String origin, Map<String, PriorityQueue<String>> routes) {

        if (routes.containsKey(origin)) {
            PriorityQueue<String> destinations = routes.get(origin);

            while (!destinations.isEmpty()) {
                String firstDestiantion = destinations.poll();
                createItinerary(firstDestiantion, routes);
            }
        }
        itinerary.addFirst(origin);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> routes = createRoutes(tickets);
        createItinerary("JFK", routes);
        return this.itinerary;
    }
    public static void main(String[] args) {
        List<List<String>> flights = new ArrayList<>();

        flights.add(Arrays.asList("JFK", "SFO"));
        flights.add(Arrays.asList("JFK", "ATL"));
        flights.add(Arrays.asList("SFO", "ATL"));
        flights.add(Arrays.asList("ATL", "JFK"));
        flights.add(Arrays.asList("ATL", "SFO"));

        System.out.println(new ReconstructItinerary().findItinerary(flights));

    }
}
