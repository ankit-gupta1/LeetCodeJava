import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int val = 0;
        int n = nums.length;
        boolean found = false;

        for (int i = 0; i < n - 2 && !found; i++) {
            int a = nums[i];

            int j = i + 1;
            int k = n - 1;
            while (j < k && !found) {
                int sum = a + nums[j] + nums[k];
                if (sum == target) {
                    found = true;
                    val = sum;
                    break;
                }

                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    val = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return val;
    }
}