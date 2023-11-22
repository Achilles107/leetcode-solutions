package graphs;

import java.util.*;

public class EvaluateDivision {
    class Pair {
        String deno;
        double val;

        public Pair(String deno, double val) {
            this.deno = deno;
            this.val = val;
        }
    }

    private double evaluate(HashMap<String, List<Pair>> relation, Queue<Pair> queue, String start, String end) {
        queue.add(new Pair(start, 1.0));
        Set<String> seen = new HashSet<>();
        seen.add(start);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentNode = current.deno;
            double currentVal = current.val;
            List<Pair> pairs = relation.get(currentNode);
            for (int i = 0; i < pairs.size(); i++) {
                Pair child = pairs.get(i);
                String childNode = child.deno;
                double childVal = child.val;
                if (childNode.equals(end))
                    return currentVal * childVal;
                if (!seen.contains(childNode)) {
                    seen.add(childNode);
                    queue.add(new Pair(childNode, currentVal * childVal));
                }
            }
        }
        return -1.0;
    }

    private HashMap<String, List<Pair>> createRelations(List<List<String>> equations, double[] values) {
        HashMap<String, List<Pair>> relation = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String num = equations.get(i).get(0);
            String deno = equations.get(i).get(1);
            if (!relation.containsKey(num)) {
                relation.put(num, new ArrayList<Pair>());
            }
            Pair pair = new Pair(deno, values[i]);
            relation.get(num).add(pair);

            if (!relation.containsKey(deno)) {
                relation.put(deno, new ArrayList<Pair>());
            }
            Pair revPair = new Pair(num, 1.0 / values[i]);
            relation.get(deno).add(revPair);
        }
        return relation;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> relation = createRelations(equations, values);
        int noOfQueries = queries.size();
        double result[] = new double[noOfQueries];

        for (int i = 0; i < queries.size(); i++) {
            Queue<Pair> queue = new LinkedList<>();
            String num = queries.get(i).get(0);
            String deno = queries.get(i).get(1);
            if (!relation.containsKey(num) || !relation.containsKey(deno)) {
                result[i] = -1.0;
                continue;
            }
            if (num.equals(deno)) {
                result[i] = 1.0;
                continue;
            }
            double val = evaluate(relation, queue, num, deno);
            result[i] = val;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
