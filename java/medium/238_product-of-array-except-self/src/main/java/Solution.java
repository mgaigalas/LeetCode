/**
 * Solution class contains solution for LeetCode problem:
 * #238. Product of Array Except Self.
 *
 * @author Marius Gaigalas on 25/09/2024
 */
public class Solution {
    /**
     * Given an integer array nums, returns an array answer such that answer[i] is equal to the product of all the
     * elements of nums except nums[i].
     * Note: The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * @param nums array of integers
     * @return product of all the elements of nums except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        final int length = nums.length;

        int[] res = new int[length];
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }
}