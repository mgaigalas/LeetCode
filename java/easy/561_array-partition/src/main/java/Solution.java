import java.util.Arrays;

/**
 * Solution class contains solution for LeetCode problem:
 * #561. Array Partition.
 *
 * @author Marius Gaigalas on 25/07/2024
 */
public class Solution {
    /**
     * Returns maximized sum.
     *
     * @param nums array nums of 2n integers
     * @return maximized sum
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int sum = 0;
        while (left < nums.length - 1) {
            sum += nums[left];
            left += 2;
        }
        return sum;
    }
}