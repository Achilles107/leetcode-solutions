package arrays_and_hashing;

import java.util.*;

public class InsertDeleteGetRandom {
    class RandomizedSet {

        private HashMap<Integer, Integer> indices;
        private List<Integer> randomizedSet;
        private int size;
        Random random;
        public RandomizedSet() {
            this.indices = new HashMap<>();
            this.randomizedSet = new ArrayList<>();
            this.size = 0;
            this.random = new Random();

        }

        public boolean insert(int val) {
            if (this.indices.containsKey(val))
                return false;
            this.randomizedSet.add(val);
            this.size++;
            this.indices.put(val, this.size-1);
            return true;
        }

        public boolean remove(int val) {
            if (!this.indices.containsKey(val))
                return false;
            int removingIdx = this.indices.get(val);
            int lastValue = this.randomizedSet.get(this.size-1);
            this.indices.put(lastValue, removingIdx);
            this.randomizedSet.set(removingIdx, lastValue);
            this.indices.remove(val);
            this.randomizedSet.remove(this.size-1);
            this.size--;
            return true;
        }

        public int getRandom() {
            return this.randomizedSet.get(random.nextInt(this.size));
        }
    }
    public static void main(String[] args) {

    }
}
