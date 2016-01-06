public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 1;
        int len = nums.length;

        while (end < len) {
            if (nums[end] == nums[end - 1]) {
                end++;
                continue;
            } else {
                nums[++start] = nums[end++];
            }
        }

        return start + 1;
    }
}