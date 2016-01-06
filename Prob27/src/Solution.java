public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int start = 0;
        int curr = 0;

        while (curr < len) {
            if (nums[curr] == val) {
                curr++;
                continue;
            } else {
                nums[start++] = nums[curr++];
            }
        }

        return start + 1;
    }
}