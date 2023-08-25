package arrays_and_hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    class HitCounter {

        private Queue<Integer> hits;

        private int limit;
        public HitCounter() {
            this.hits = new LinkedList<>();
            this.limit = 300;
        }

        public void hit(int timestamp) {
            this.hits.add(timestamp);
        }

        public int getHits(int timestamp) {
            while (!this.hits.isEmpty()) {
                if (timestamp - this.hits.peek() >= limit) this.hits.remove();
                else break;
            }
            return this.hits.size();
        }
    }
    public static void main(String[] args) {

    }
}
