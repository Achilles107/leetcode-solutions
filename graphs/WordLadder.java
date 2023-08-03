package graphs;

import java.util.*;

public class WordLadder {

    private Map<String, List<String>> createGraph(String beginWord, String endWord, List<String> wordList) {
        //wordList.add(0, beginWord);

        int size = beginWord.length();
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : wordList) {
            graph.put(word, new ArrayList<>());
        }
        for (String rootWord : wordList) {
            for (String childWord : wordList) {
                if (!rootWord.equals(childWord)) {
                    if (differByOne(rootWord, childWord, size)) {
                        graph.get(rootWord).add(childWord);
                    }
                }
            }
        }

        return graph;
    }

    private boolean differByOne(String rootWord, String childWord, int size) {
        int differeceCount = 0;
        for (int i = 0; i < size; i++) {
            if (rootWord.charAt(i) != childWord.charAt(i)) {
                differeceCount++;
            }
            if (differeceCount > 1)
                return false;
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        if (!wordList.contains(beginWord)) {
            wordList.add(0, beginWord);
        }
        Map<String, List<String>> graph = createGraph(beginWord, endWord, wordList);
        //System.out.println(graph);
        return bfs(graph, beginWord, endWord);
    }

    private int bfs(Map<String, List<String>> graph, String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = 1;
        Set<String> seen = new TreeSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return length;
                List<String> childWords = graph.get(word);
                for (String child : childWords) {
                    if (!seen.contains(child)) {
                        queue.add(child);
                        seen.add(child);
                    }
                }

            }
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));

    }
}
