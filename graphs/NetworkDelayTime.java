package graphs;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int min_values_array[] = new int[n+1];
        Arrays.fill(min_values_array, Integer.MAX_VALUE);

        HashMap<Integer, List<int[]>> networktime = new HashMap<>();
        for (int i=1; i<=n; i++){
            networktime.put(i, new ArrayList<>());
        }
        for (int i =0; i<times.length; i++){
            int targets[] = {times[i][1], times[i][2]};
            networktime.get(times[i][0]).add(targets);
        }

        bfs(k, networktime, min_values_array);
        int result = Integer.MIN_VALUE;
        for (int i =1; i<min_values_array.length; i++){
            result = Math.max(result, min_values_array[i]);
            if (result == Integer.MAX_VALUE)
                return -1;
        }
        return result;
    }

    private void bfs(int k, HashMap<Integer, List<int[]>> networktime, int[] minValuesArray) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(k);
        minValuesArray[k] = 0;

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            List<int[]> networks = networktime.get(currNode);
            for (int i =0; i<networks.size(); i++){
                int childNode = networks.get(i)[0];
                minValuesArray[childNode] = Math.min(minValuesArray[childNode], minValuesArray[currNode] + networks.get(i)[1]);
                queue.add(childNode);
            }
        }
    }

    public static void main(String[] args) {

    }
}
