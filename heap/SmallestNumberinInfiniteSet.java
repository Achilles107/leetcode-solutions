package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SmallestNumberinInfiniteSet {
    class SmallestInfiniteSet1 {

        private PriorityQueue<Integer> minFirst;
        private boolean isRemoved[];
        private final int num = 1000;

        public SmallestInfiniteSet1() {
            this.minFirst = new PriorityQueue<>();
            isRemoved = new boolean[num];
            for (int i = 1; i <= num; i++) {
                this.minFirst.add(i);
            }
        }

        public int popSmallest() {
            this.isRemoved[this.minFirst.peek().intValue()] = true;
            return this.minFirst.poll().intValue();
        }

        public void addBack(int num) {
            if (this.isRemoved[num]) {
                this.minFirst.add(num);
                this.isRemoved[num] = false;
            }
        }
    }

    class SmallestInfiniteSet {

        private PriorityQueue<Integer> minFirst;
        private HashMap<Integer, Boolean> isRemoved;

        private int currentSmallest;

        public SmallestInfiniteSet() {
            this.minFirst = new PriorityQueue<>();
            isRemoved = new HashMap<>();
            this.currentSmallest = 1;
        }

        public int popSmallest() {
            if (minFirst.isEmpty()) {
                this.isRemoved.put(this.currentSmallest, true);
                return this.currentSmallest++;
            }

            if (minFirst.peek().intValue() > currentSmallest) {
                this.isRemoved.put(currentSmallest, true);
                return this.currentSmallest++;
            }
            int smallest = minFirst.poll().intValue();
            this.isRemoved.put(smallest, true);
            return smallest;
        }

        public void addBack(int num) {
            if (isRemoved.containsKey(num) && isRemoved.get(num)) {
                this.isRemoved.put(num, false);
                this.minFirst.add(num);
            }
        }
    }
}
