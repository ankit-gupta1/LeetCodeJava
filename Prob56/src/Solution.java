import java.util.*;

/**
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.start > i2.start) {
            return 1;
        } else if (i1.start < i2.start) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        if (intervals.size() > 0) {
            Interval prev = intervals.get(0);
            int i = 1;
            while (i < intervals.size()) {
                Interval curr = intervals.get(i);
                if (prev.end >= curr.start) {
                    prev.end = Math.max(prev.end, curr.end);
                    intervals.set(i - 1, prev);
                    intervals.remove(i);
                } else {
                    prev = curr;
                    i++;
                }
            }
        }

        return intervals;
    }
}