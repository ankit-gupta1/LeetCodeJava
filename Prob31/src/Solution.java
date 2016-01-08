public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] > nums[i]) {
                k = i - 1;
                break;
            }
        }

        if (k == -1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = nums[n - 1 - i];
                nums[n - 1 - i] = nums[i];
                nums[i] = temp;
            }
        } else {
            int l = -1;
            for (int i = n - 1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    l = i;
                    break;
                }
            }

            int temp = nums[l];
            nums[l] = nums[k + 1];
            nums[k + 1] = temp;

            for (int i = k + 1; i < k + 1 + ((n - k - 1) / 2); i++) {
                temp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = temp;
            }
        }
    }
}