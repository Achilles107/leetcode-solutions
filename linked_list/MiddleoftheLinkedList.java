package linked_list;

import java.util.LinkedList;
import java.util.List;

public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        List<ListNode> nodes = new LinkedList<>();

        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int len = nodes.size();
        return nodes.get(len/2);
    }
}
