/**
 * Solution class contains solution for LeetCode problem:
 * #26. Remove Duplicates from Sorted Array.
 *
 * @author Marius Gaigalas on 04/06/2024
 */
public class Solution {
    /**
     * Given an integer array nums sorted in non-decreasing order, removes the duplicates in-place
     * such that each unique element appears only once.
     * The relative order of the elements is being kept the same.
     * Returns the number of unique elements in nums.
     *
     * @param nums array of integers
     * @return number of unique elements in nums
     */
    public int removeDuplicates(int[] nums) {
        var insertionIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertionIndex] = nums[i];
                insertionIndex++;
            }
        }
        return insertionIndex;
    }
}