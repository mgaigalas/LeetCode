/**
 * Solution class contains solution for LeetCode problem:
 * #167. Two Sum II - Input Array Is Sorted.
 *
 * @author Marius Gaigalas on 06/09/2024
 */
public class Solution {
    /**
     * Finds two numbers such that they add up to a specific target number.
     * Returns the indices of the two numbers, added by one as an integer array [index1, index2] of length 2.
     *
     * @param numbers sorted array of numbers
     * @param target  target sum
     * @return array of indices of the two numbers
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            final int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{++left, ++right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}