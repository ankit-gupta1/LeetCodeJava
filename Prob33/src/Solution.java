public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int idx = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] > nums[hi]) {
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return idx;
    }
}