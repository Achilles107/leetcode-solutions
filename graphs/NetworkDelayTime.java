package graphs;

import java.util.*;

public class NetworkDelayTime {
    private Map<Integer, List<int[]>> networks(int[][] times, int n) {
        Map<Integer, List<int[]>> networks = new HashMap<>();
        for(int node =1; node<=n; node++) {
            networks.put(node, new ArrayList<int[]>());
        }
        for (int time[]: times) {
            networks.get(time[0]).add(new int[]{time[1], time[2]});
        }
        return networks;
    }

    private void sendSignal(Map<Integer, List<int[]>> networks, int minValuesToReach[], int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        minValuesToReach[k] = 0;

        while (!queue.isEmpty()) {
            int currVal = queue.poll();
            if (!networks.containsKey(currVal))
                continue;
            List<int[]> neighbouringNodes = networks.get(currVal);
            for (int[] node: neighbouringNodes) {
                int neighNode = node[0];
                int currTime = node[1];
                int prevVal = minValuesToReach[neighNode];
                minValuesToReach[neighNode] = Math.min(minValuesToReach[neighNode], minValuesToReach[currVal] + currTime);
                if (prevVal > minValuesToReach[neighNode])
                    queue.add(neighNode);
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // created network connections
        Map<Integer, List<int[]>> networks = networks(times, n);
        int minValuesToReach[] = new int[n+1];
        Arrays.fill(minValuesToReach, Integer.MAX_VALUE);
        sendSignal(networks, minValuesToReach, k);
        int networkDelayTime = 0;
        for (int time = 1; time<minValuesToReach.length; time++) {
            if (minValuesToReach[time] == Integer.MAX_VALUE)
                return -1;
            networkDelayTime = Math.max(networkDelayTime, minValuesToReach[time]);
        }
        return networkDelayTime;
    }

    public static void main(String[] args) {
        int[][] times = { {2, 1, 1}, {2, 3, 1}, {3, 4, 1} };
        int n = 4;
        int k = 2;

    }
}
