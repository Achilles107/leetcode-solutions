package intervals;

import java.util.PriorityQueue;

public class MinimumNumberofArrowstoBurstBalloons {

    private boolean doesMerge(int[] recentOne, int[] nextOne) {
        return (Math.min(recentOne[1], nextOne[1]) - Math.max(recentOne[0], nextOne[0]) >= 0);
    }

    private int[] merge(int[] recentOne, int[] nextOne) {
        int merged[] = {Math.max(recentOne[0], nextOne[0]), Math.min(recentOne[1], nextOne[1])};
        return merged;
    }
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> minYFirst = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int len = points.length;
        for (int[] point: points)
            minYFirst.add(point);

        int arrows = 0;
        while (!minYFirst.isEmpty() && minYFirst.size() > 1) {
            int[] recentOne = minYFirst.poll();
            if (doesMerge(recentOne, minYFirst.peek())) {
                int[] nextOne = minYFirst.poll();
                minYFirst.add(merge(recentOne, nextOne));
            } else {
                arrows++;
            }
        }
        return arrows + minYFirst.size();
    }
}
