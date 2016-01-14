/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head != null) {
            ListNode prev = null;
            ListNode curr = head;
            int n = 0;

            while (curr != null) {
                prev = curr;
                curr = curr.next;
                n++;
            }

            k = k % n;
            if (k > 0) {
                int count = 1;
                curr = head;
                while (count < n - k) {
                    curr = curr.next;
                    count++;
                }

                ListNode shift = curr.next;
                curr.next = null;
                prev.next = head;
                head = shift;
            }
        }

        return head;
    }
}