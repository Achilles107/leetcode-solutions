package linked_list;

public class DesignBrowserHistory {
    class BrowserHistory {

        class Node {
            public String val;
            public Node next;

            public Node prev;

            public Node(String val) {
                this.val = val;
            }

            public Node(String val, Node next, Node prev) {
                this.val = val;
                this.next = next;
                this.prev = prev;
            }

        }

        public Node head;
        public BrowserHistory(String homepage) {
            head = new Node(homepage);
        }

        public void visit(String url) {
            Node newPage = new Node(url);
            head.next = newPage;
            newPage.prev = head;
        }

        public String back(int steps) {
            while (head.prev != null && steps-->0) {
                head = head.prev;
            }
            return head.val;
        }

        public String forward(int steps) {
            while (head.next != null && steps-->0) {
                head = head.next;
            }
            return head.val;
        }
    }
    public static void main(String[] args) {

    }
}
