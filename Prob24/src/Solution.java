class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head != null) {
            ListNode first = head;
            ListNode second = head.next;
            ListNode prev = null;

            while (first != null && second != null) {
                ListNode next = second.next;
                first.next = next;
                second.next = first;

                if (prev == null) {
                    head = second;
                } else {
                    prev.next = second;
                }

                prev = first;
                first = next;
                if (next != null) {
                    second = next.next;
                } else {
                    second = null;
                }
            }
        }

        return head;
    }
}