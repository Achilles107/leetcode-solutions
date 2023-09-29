package linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftPart = new ListNode(-300);
        ListNode rightPart = new ListNode(-300);
        ListNode tempLeft = leftPart;
        ListNode tempRight = rightPart;

        while (head != null) {
            if (head.val < x) {
                tempLeft.next = head;
                tempLeft = tempLeft.next;
            } else {
                tempRight.next = head;
                tempRight = tempRight.next;
            }
            head = head.next;
        }
        tempLeft.next = rightPart.next;
        tempRight.next = null;
        return leftPart.next;
    }
    public static void main(String[] args) {

    }
}
