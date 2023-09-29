package linked_list;

public class DesignLinkedList {
    class MyLinkedList {
        ListNode head;
        ListNode tail;
        public MyLinkedList() {
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
        }

        public int get(int index) {
            ListNode temp = head;
            while (index-- >= 0 && temp != null) {
                temp = temp.next;
            }
            return temp != null ? temp.val : -1;
        }

        public void addAtHead(int val) {
            ListNode nextHead = head.next;
            head.next = new ListNode(val);
            head.next.next = nextHead;
        }

        public void addAtTail(int val) {
            tail.val = val;
            tail.next = new ListNode(-1);
            tail = tail.next;
        }

        public void addAtIndex(int index, int val) {
            ListNode temp = head;
            ListNode prev = null;
            while (index-- >= 0 && temp!= null) {
                prev = temp;
                temp = temp.next;
            }
            if (temp != null) {
                prev.next = new ListNode(val);
                prev.next.next = temp;
            }
            else {
                prev.next = new ListNode(val);
            }
        }

        public void deleteAtIndex(int index) {
            ListNode temp = head;
            ListNode prev = null;

            while (index-- >=0 && temp!=null) {
                prev = temp;
                temp = temp.next;
            }
            if(temp == null || temp.val == -1) return;
            ListNode nextNode = temp.next;
            prev.next = nextNode;
            temp.next = null;
        }
    }

    public static void main(String[] args) {

    }
}
