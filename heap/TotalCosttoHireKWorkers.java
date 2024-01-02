package heap;

import java.util.PriorityQueue;

public class TotalCosttoHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<int[]> minFirst = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        if (candidates != 1 && candidates > costs.length / 2)
            candidates = costs.length / 2;
        int i;
        for (i = 0; i < candidates; i++) {
            minFirst.add(new int[]{i, costs[i]});
        }

        int j;
        for (j = costs.length - 1; j >= costs.length - candidates; j--) {
            minFirst.add(new int[]{j, costs[j]});
        }

        long totalCost = 0;
        while (k-- > 0 && !minFirst.isEmpty()) {
            int[] cheapestWorker = minFirst.poll();
            int cheapestIndx = cheapestWorker[0];
            int cheapestCost = cheapestWorker[1];
            totalCost += cheapestCost;
            if (i > j)
                continue;
            if (cheapestIndx < i) {
                minFirst.add(new int[]{i, costs[i]});
                i++;
            }
            if (cheapestIndx > j) {
                minFirst.add(new int[]{j, costs[j]});
                j--;
            }
        }
        return totalCost;
    }
}
