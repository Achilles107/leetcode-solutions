package graphs;

import java.util.*;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, List<Integer>> roomsMap = new HashMap<>();
        for (int i =0; i< rooms.size(); i++){
            roomsMap.put(i, rooms.get(i));
        }
        boolean visited[] = new boolean[roomsMap.size()];
        bfs(0, roomsMap, visited);
        for (int i=0; i<visited.length; i++){
            if (!visited[i])
                return false;
        }
        return true;
    }

    private void bfs(int unlockedRoom, HashMap<Integer, List<Integer>> roomsMap, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(unlockedRoom);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node])
                continue;
            visited[node] = true;
            List<Integer> children = roomsMap.get(node);
            for (int child: children){
                queue.add(child);
            }
        }
    }

    public static void main(String[] args) {

    }
}
