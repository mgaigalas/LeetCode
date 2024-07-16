/**
 * Solution class contains solution for LeetCode problem:
 * #263. Ugly Number.
 *
 * @author Marius Gaigalas on 16/07/2024
 */
public class Solution {
    /**
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     * Given an integer n, returns true if n is an ugly number.
     *
     * @param n number
     * @return flag indicating if number is ugly
     */
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }

        final int[] factors = new int[]{2, 3, 5};
        var hasNext = true;
        while (hasNext) {
            hasNext = false;
            for (int factor : factors) {
                if (n % factor != 0) {
                    continue;
                }
                hasNext = true;
                n /= factor;
                break;
            }
        }
        return n == 1;
    }
}