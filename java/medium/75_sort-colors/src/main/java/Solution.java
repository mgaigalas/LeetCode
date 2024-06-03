/**
 * Solution class contains solution for LeetCode problem:
 * #75. Sort Colors.
 *
 * @author Marius Gaigalas on 29/05/2024
 */
public class Solution {
    /**
     * Given an array nums with n objects, returns sorted in-place objects.
     * This solution uses Selection Sort.
     *
     * @param nums an array of integers
     */
    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int min_element_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min_element_index]) {
                    min_element_index = j;
                }
            }

            int temp = nums[min_element_index];
            nums[min_element_index] = nums[i];
            nums[i] = temp;
        }
    }
}