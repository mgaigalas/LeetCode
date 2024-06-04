/**
 * Solution class contains solution for LeetCode problem:
 * #27. Remove Element.
 *
 * @author Marius Gaigalas on 04/06/2024
 */
public class Solution {
    /**
     * Given an integer array nums and an integer val, removes all occurrences of val in nums in-place.
     * The order of the elements may be changed.
     * Then returns the number of elements in nums which are not equal to val.
     *
     * @param nums array of integers
     * @param val value to be removed
     * @return number of elements in nums which are not equal to val
     */
    public int removeElement(int[] nums, int val) {
        var writer = 0;
        for (int reader = 0; reader < nums.length; reader++) {
            if (nums[reader] != val) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }
}