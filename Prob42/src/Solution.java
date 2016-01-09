public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int water = 0;

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int val = Math.min(left[i], right[i]) - height[i];
            water += val > 0 ? val : 0;
        }

        return water;
    }
}