class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return  head;
        }

        ListNode start = head;
        ListNode last = null;
        ListNode prevK;
        int count;

        do {
            ListNode curr = start;
            ListNode prev = null;
            count = 0;

            while (count < k && curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if (last == null) {
                head = prev;
            } else {
                last.next = prev;
            }

            prevK = last;
            last = start;
            start.next = curr;
            start = curr;
        } while (start != null);

        if (count < k) {
            ListNode curr = prevK == null ? head : prevK.next;
            ListNode prev = null;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (prevK == null) {
                head = prev;
            } else {
                prevK.next = prev;
            }
        }

        return head;
    }
}