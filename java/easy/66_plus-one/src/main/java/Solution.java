/**
 * Solution class contains solution for LeetCode problem:
 * #66. Plus One.
 *
 * @author Marius Gaigalas on 10/07/2024
 */
public class Solution {
    /**
     * Given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer.
     * The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increments the large integer by one and returns the resulting array of digits.
     *
     * @param digits number in a form of array
     * @return result number in a form of array
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                continue;
            }
            digits[i]++;
            return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}