class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode prev = null;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                prev = p1;
                p1 = p1.next;
            } else {
                if (prev == null) {
                    ListNode temp = p2;
                    p2 = p2.next;
                    temp.next = p1;
                    l1 = temp;
                    prev = temp;
                } else {
                    prev.next = p2;
                    p2 = p2.next;
                    prev.next.next = p1;
                    prev = prev.next;
                }
            }
        }

        if (p2 != null) {
            if (prev == null) {
                l1 = p2;
            } else {
                prev.next = p2;
            }
        }

        return l1;
    }
}