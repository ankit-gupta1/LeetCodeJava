public class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int n = nums.length;
        int i = 0;

        while(i < n - 1) {
            int maxVal = 0;
            int nextJump = 0;
            int j = i + 1;

            if (i + nums[i] >= n - 1) {
                i += nums[i];
            } else {
                while (j < n && j <= (i + nums[i])) {
                    if (maxVal <= nums[j]) {
                        maxVal = nums[j];
                        nextJump = j;
                    }

                    j++;
                }

                i = nextJump;
            }

            steps++;
        }

        return steps;
    }
}