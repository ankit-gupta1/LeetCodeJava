class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0);
        int c = 0;
        ListNode ref = r;

        while (l1 != null || l2 != null) {
            int val = c;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            c = val / 10;
            ListNode n = new ListNode(val % 10);
            ref.next = n;
            ref = ref.next;
        }

        if (c > 0) {
            ListNode n = new ListNode(c);
            ref.next = n;
        }

        return r.next;
    }
}