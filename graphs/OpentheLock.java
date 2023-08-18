package graphs;

import java.util.*;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        List<String> deadendsList = new LinkedList<>();
        for (String deadend : deadends) {
            deadendsList.add(deadend);
        }
        if (deadendsList.contains("0000")) return -1;
        Set<String> seen = new TreeSet<>();
        Queue<String> neighbours = new LinkedList<>();
        neighbours.add("0000");
        seen.add("0000");
        int depth = 0;
        while (!neighbours.isEmpty()) {
            int size = neighbours.size();
            for (int i = 0; i < size; i++) {
                String currCombination = neighbours.poll();
                if (currCombination.equals(target)) {
                    return depth;
                }
                List<String> nextCombinations = getCombinations(currCombination);
                for (String next : nextCombinations) {
                    if (!deadendsList.contains(next) && !seen.contains(next)) {
                        seen.add(next);
                        neighbours.add(next);
                    }
                }
            }
            depth += 1;
        }
        return -1;
    }

    private List<String> getCombinations(String currCombination) {
        List<String> nextCombinations = new ArrayList<>();
        for (int i = 0; i < currCombination.length(); i++) {
            for (int inc = -1; inc <= 1; inc += 2) {
                int nextDigit = ((currCombination.charAt(i) - '0') + inc + 10) % 10;
                String nextComb = currCombination.substring(0, i) + nextDigit + currCombination.substring(i + 1);
                nextCombinations.add(nextComb);
            }
        }
        return nextCombinations;
    }

    public static void main(String[] args) {

    }
}
