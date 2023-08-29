package heap;

import java.util.*;

public class TopKFrequentWords {

    private PriorityQueue<String> getTopK(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> topK = new PriorityQueue<>((a,b) -> {
            int countA = count.get(a);
            int countB = count.get(b);

            if (countA > countB)
                return 1;
            else if (countB > countA)
                return -1;
            else {
                return a.compareTo(b) > 0 ? -1 : 1;
            }
        });
        for (String word: count.keySet()) {
            topK.offer(word);
            if (k < topK.size())
                topK.poll();
        }
        return topK;
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<String> topK = getTopK(words, k);
        LinkedList<String> result = new LinkedList<>();
        while (!topK.isEmpty()) {
            result.addFirst(topK.poll());
        }
        return result;
    }
    public static void main(String[] args) {
        String words[] = {"the","day","is","sunny","the","the","the","sunny", "sunny","is","is"};
        System.out.println(new TopKFrequentWords().topKFrequent(words, 3));
    }
}
