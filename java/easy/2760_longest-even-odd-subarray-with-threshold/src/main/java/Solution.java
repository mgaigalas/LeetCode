/**
 * Solution class contains solution for LeetCode problem:
 * #2760. Longest Even Odd Subarray With Threshold.
 *
 * @author Marius Gaigalas on 20/08/2024
 */
public class Solution {
    /**
     * Returns an integer denoting the length of the longest subarray that satisfies the following conditions:
     * <ul>
     *     <li>nums[l] % 2 == 0</li>
     *     <li>For all indices i in the range [l, r - 1], nums[i] % 2 != nums[i + 1] % 2</li>
     *     <li>For all indices i in the range [l, r], nums[i] <= threshold</li>
     * </ul>
     *
     * @param nums      0-indexed integer array
     * @param threshold integer indicating threshold
     * @return length of the longest subarray of nums
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        int left = 0;
        while (left < nums.length) {
            if (nums[left] % 2 != 0 || nums[left] > threshold) {
                left++;
                continue;
            }

            int right = left + 1;
            while (right < nums.length && nums[right - 1] % 2 != nums[right] % 2 && nums[right] <= threshold) {
                right++;
            }
            res = Math.max(res, right - left);
            left = right;
        }
        return res;
    }
}