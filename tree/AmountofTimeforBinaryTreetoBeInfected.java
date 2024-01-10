package tree;

import java.util.*;

public class AmountofTimeforBinaryTreetoBeInfected {
    private HashMap<Integer, List<Integer>> createGraph(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (!graph.containsKey(currNode.val)) {
                    graph.put(currNode.val, new ArrayList<>());
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                    graph.get(currNode.val).add(currNode.left.val);
                    if (!graph.containsKey(currNode.left.val)) {
                        graph.put(currNode.left.val, new ArrayList<>());
                    }
                    graph.get(currNode.left.val).add(currNode.val);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                    graph.get(currNode.val).add(currNode.right.val);
                    if (!graph.containsKey(currNode.right.val)) {
                        graph.put(currNode.right.val, new ArrayList<>());
                    }
                    graph.get(currNode.right.val).add(currNode.val);
                }
            }
        }
        return graph;
    }

    private int timeTaken(HashMap<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currNode = queue.poll();
                List<Integer> neighbours = graph.get(currNode);
                for (int neighbour : neighbours) {
                    if (!seen.contains(neighbour)) {
                        seen.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
            minutes += 1;
        }
        return minutes;
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> graph = createGraph(root);
        return timeTaken(graph, start);
    }
}
