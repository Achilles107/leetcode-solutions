package linked_list;

import java.util.PriorityQueue;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        PriorityQueue<ListNode> minFirst = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

        while (head != null) {
            minFirst.add(new ListNode(head.val));
            head = head.next;
        }
        ListNode sortedHead = new ListNode(-1);
        ListNode temp = sortedHead;
        while (!minFirst.isEmpty()) {
            temp.next = minFirst.poll();
            temp = temp.next;
        }
        return sortedHead.next;
    }
    public static void main(String[] args) {

    }
}
