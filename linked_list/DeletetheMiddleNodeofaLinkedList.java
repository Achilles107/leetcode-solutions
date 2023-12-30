package linked_list;

public class DeletetheMiddleNodeofaLinkedList {

    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int length = length(temp);
        int middle = length / 2;
        temp = head;
        ListNode prevNode = null;
        if (middle == 0)
            return head;
        while (middle > 0) {
            prevNode = temp;
            temp = temp.next;
            middle--;
        }

        prevNode.next = temp.next;
        temp.next = null;
        return head;
    }
}
