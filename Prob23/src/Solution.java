import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class CustomComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> x, ArrayList<Integer> y) {
        if (x.get(1) > y.get(1)) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(1, new CustomComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(new ArrayList<>(Arrays.asList(i, lists[i].val)));
                lists[i] = lists[i].next;
            }
        }

        ListNode iterator = result;
        while (!queue.isEmpty()) {
            ArrayList<Integer> tuple = queue.poll();
            int idx = tuple.get(0);
            iterator.next = new ListNode(tuple.get(1));
            iterator = iterator.next;

            if (lists[idx] != null) {
                tuple.set(1, lists[idx].val);
                queue.add(tuple);
                lists[idx] = lists[idx].next;
            }
        }

        return result.next;
    }
}