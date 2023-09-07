package linked_list;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class ReorderList {

    private int len(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;

    }
    public void reorderList(ListNode head) {
        ListNode temp = head;
        int len = len(head);
        int firstHalfLen = 0;
        if (len % 2 == 0) {
            firstHalfLen = len/2;
        } else {
            firstHalfLen = (len/2)+1;
        }
        ListNode[] secondHalf = new ListNode[len - firstHalfLen];
        temp = head;
        int idx = 0;
        while (temp != null && idx < firstHalfLen) {
            idx++;
            temp = temp.next;
        }
        idx = 0;
        while (temp != null && idx < secondHalf.length) {
            secondHalf[idx++] = temp;
            temp = temp.next;
        }
        idx = secondHalf.length-1;
        temp = head;
        while (temp != null && idx >= 0) {
            ListNode nextNode = temp.next;
            temp.next = secondHalf[idx--];
            temp.next.next = nextNode;
            temp = nextNode;
        }
        temp.next = null;
    }
}
