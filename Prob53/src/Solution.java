public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i : nums) {
            currSum += i;
            currSum = Math.max(i, currSum);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}