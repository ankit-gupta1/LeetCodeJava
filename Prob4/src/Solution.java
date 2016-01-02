public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int i, j, imin = 0, imax = m, half = (m + n + 1) / 2;
        int num1 = 0;
        int num2 = 0;

        while (imin <= imax) {
            i = (imin & imax) + ((imin ^ imax) >> 1);
            j = half - i;

            if (i > 0 && j < n && nums1[i - 1] > nums2[j]) imax = i - 1;
            else if (j > 0 && i < m && nums2[j - 1] > nums1[i]) imin = i + 1;
            else {

                if (i == 0) num1 = nums2[j - 1];
                else if (j == 0) num1 = nums1[i - 1];
                else num1 = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1) {
                    num2 = num1;
                    break;
                }

                if (i == m) num2 = nums2[j];
                else if (j == n) num2 = nums1[i];
                else num2 = Math.min(nums1[i], nums2[j]);
                break;
            }
        }

        return (num1 + num2) / 2.0;
    }
}