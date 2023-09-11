package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackusingQueues {
    class MyStack {

        private Deque<Integer> lifo;

        public MyStack() {
            lifo = new ArrayDeque<>();
        }

        public void push(int x) {
            lifo.addFirst(x);
        }

        public int pop() {
            if (lifo.isEmpty())
                return -1;
            int lastIn = lifo.removeFirst();
            return lastIn;
        }

        public int top() {
            if (lifo.isEmpty())
                return -1;
            int lastIn = lifo.getFirst();
            return lastIn;
        }

        public boolean empty() {
            return lifo.isEmpty();
        }
    }
    public static void main(String[] args) {

    }
}
