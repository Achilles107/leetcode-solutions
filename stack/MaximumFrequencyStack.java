package stack;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MaximumFrequencyStack {

    class FreqStack {

        class Item {
            public int position;
            public int value;
            public int freq;
            public Item(int position, int value, int freq) {
                this.position = position;
                this.value = value;
                this.freq = freq;
            }
        }
        private HashMap<Integer, Integer> frequencies;

        private PriorityQueue<Item> maxFirst;

        private int pos;
        public FreqStack() {
            this.pos = 0;
            frequencies = new HashMap();
            maxFirst = new PriorityQueue<>((b,a) -> {
                int freqA = a.freq;
                int posA = a.position;
                int freqB = b.freq;
                int posB = b.position;

                if (freqA != freqB) {
                    return Integer.compare(freqA, freqB);
                }

                return Integer.compare(posA, posB);
            });
        }

        public void push(int val) {
            frequencies.put(val, frequencies.getOrDefault(val, 0) + 1);
            Item newVal = new Item(this.pos++, val, frequencies.get(val));
            maxFirst.add(newVal);
        }

        public int pop() {
            Item popped = maxFirst.poll();
            frequencies.put(popped.value, frequencies.get(popped.value) - 1);
            return popped.value;
        }
    }
    public static void main(String[] args) {

    }
}
