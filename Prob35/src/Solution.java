public class Solution {
    public int searchInsert(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                lo = mid;
                break;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}