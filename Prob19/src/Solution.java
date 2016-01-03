class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode fwd = head;
        while (count < n + 1) {
            fwd = fwd.next;
            count++;
        }

        ListNode curr = head;
        if (fwd == null) {
            head = head.next;
        } else {
            while (fwd.next != null) {
                curr = curr.next;
                fwd = fwd.next;
            }
            curr.next = curr.next.next;
        }

        return head;
    }
}