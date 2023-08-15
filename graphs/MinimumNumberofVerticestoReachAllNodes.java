package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberofVerticestoReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int node =0; node<n; node++) {
            graph.put(node, new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            int parent = edge.get(0);
            int child = edge.get(1);
            graph.get(child).add(parent);
        }
        List<Integer> result = new ArrayList<>();
        for (int node=0; node<n; node++) {
            if (graph.get(node).isEmpty()) {
                result.add(node);
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
