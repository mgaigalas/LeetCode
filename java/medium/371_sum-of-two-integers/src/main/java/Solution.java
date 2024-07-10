/**
 * Solution class contains solution for LeetCode problem:
 * #371. Sum of Two Integers.
 *
 * @author Marius Gaigalas on 10/07/2024
 */
public class Solution {
    /**
     * Given two integers a and b, returns the sum of the two integers without using the operators + and -.
     *
     * @param a first integer
     * @param b second integer
     * @return sum of the two integers without using the operators + and -
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            var sum = a ^ b;
            var carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}