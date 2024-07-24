/**
 * Solution class contains solution for LeetCode problem:
 * #643. Maximum Average Subarray I.
 *
 * @author Marius Gaigalas on 24/07/2024
 */
public class Solution {
    /**
     * Finds a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     *
     * @param nums array of int
     * @param k    length of sub-array
     * @return maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        var sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        var res = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            res = Math.max(res, sum);
        }

        return (double) res / k;
    }
}