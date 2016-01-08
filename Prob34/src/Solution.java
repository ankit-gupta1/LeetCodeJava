public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;

        int hi = nums.length - 1;
        int lo = 0;

        if (nums[hi] >= target && target <= nums[lo]) {
            while (lo < hi && nums[lo] != nums[hi]) {
                int mid = lo + (hi - lo) / 2;

                if (target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }

            if (nums[hi] == target) {
                range[1] = hi;
                lo = 0;

                while (lo < hi && nums[lo] != nums[hi]) {
                    int mid = lo + (hi - lo) / 2;
                    if (target > nums[mid]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                if (nums[lo] == target) {
                    range[0] = lo;
                }
            }
        }

        return range;
    }
}