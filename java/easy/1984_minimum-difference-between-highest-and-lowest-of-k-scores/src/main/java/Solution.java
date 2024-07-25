import java.util.Arrays;

/**
 * Solution class contains solution for LeetCode problem:
 * #1984. Minimum Difference Between Highest and Lowest of K Scores.
 *
 * @author Marius Gaigalas on 25/07/2024
 */
public class Solution {
    /**
     * Returns the minimum possible difference.
     *
     * @param nums 0-indexed integer array
     * @param k    number of students to pick from
     * @return number indicating minimum possible difference
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = k - 1;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            res = Math.min(res, nums[right] - nums[left]);
            left++;
            right++;
        }

        return res;
    }
}