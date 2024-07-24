/**
 * Solution class contains solution for LeetCode problem:
 * #2932. Maximum Strong Pair XOR I.
 *
 * @author Marius Gaigalas on 24/07/2024
 */
public class Solution {
    /**
     * Returns the maximum XOR value out of all possible strong pairs in the array nums.
     *
     * @param nums array of numbers
     * @return maximum XOR value
     */
    public int maximumStrongPairXor(int[] nums) {
        var res = 0;
        for (int right = 0; right < nums.length; right++) {
            for (int left = 0; left <= right; left++) {
                if (Math.abs(nums[left] - nums[right]) > Math.min(nums[left], nums[right])) {
                    continue;
                }
                res = Math.max(res, nums[left] ^ nums[right]);
            }
        }
        return res;
    }
}