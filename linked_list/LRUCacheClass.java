package linked_list;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheClass {
    class LRUCache {
        class Node {
            int val;
            int key;
            Node next;
            Node prev;

            public Node(int key, int val, Node prev, Node next) {
                this.val = val;
                this.key = key;
                this.next = next;
                this.prev = prev;
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node head;
        Node tail;
        int capacity;
        int size;
        Map<Integer, Node> tracking;
        public LRUCache(int capacity) {
            this.head = new Node(-1,-1);
            this.tail = new Node(-2, -2);
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.capacity = capacity;
            tracking = new HashMap<>();
            this.size = 0;
        }

        public int get(int key) {
            if (tracking.containsKey(key)) {
                Node currNode = tracking.get(key);
                Node nextNode = currNode.next;
                Node prevNode = currNode.prev;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                Node mostRecentUsed = this.tail.prev;
                mostRecentUsed.next = currNode;
                currNode.prev = mostRecentUsed;
                currNode.next = this.tail;
                this.tail.prev = currNode;
                return currNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (tracking.containsKey(key)) {
                Node currNode = tracking.get(key);
                currNode.val = value;
                Node nextNode = currNode.next;
                Node prevNode = currNode.prev;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                Node mostRecentUsed = this.tail.prev;
                mostRecentUsed.next = currNode;
                currNode.next = this.tail;
                currNode.prev = mostRecentUsed;
                this.tail.prev = currNode;
            } else {
                if (this.size >= this.capacity) {
                    Node leastRecUsed = this.head.next;
                    Node secLeastUsed = leastRecUsed.next;
                    secLeastUsed.prev = this.head;
                    Node newNode = new Node(key, value);
                    this.head.next = secLeastUsed;
                    Node mostRecUsed = this.tail.prev;
                    mostRecUsed.next = newNode;
                    newNode.prev = mostRecUsed;
                    newNode.next = this.tail;
                    this.tail.prev = newNode;
                    tracking.remove(leastRecUsed.key);
                    tracking.put(key, newNode);
                } else {
                    Node newNode = new Node(key, value);
                    Node mostRecUsed = this.tail.prev;
                    mostRecUsed.next = newNode;
                    newNode.prev = mostRecUsed;
                    newNode.next = this.tail;
                    this.tail.prev = newNode;
                    tracking.put(key, newNode);
                    this.size++;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
