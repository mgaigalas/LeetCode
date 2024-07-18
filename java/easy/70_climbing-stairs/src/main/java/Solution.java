import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #70. Climbing Stairs.
 *
 * @author Marius Gaigalas on 18/07/2024
 */
public class Solution {
    private final Map<Integer, Integer> memo = new HashMap<>();

    /**
     * Calculates how many distinct ways can be climbed to the top.
     *
     * @param n steps to reach top
     * @return number of distinct ways to climb
     */
    public int climbStairs(int n) {
        return dp(n);
    }

    /**
     * Dynamic programming method for calculating number of distinct ways to climb.
     *
     * @param n steps to reach top from existing position
     * @return number of distinct ways to climb
     */
    private int dp(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, dp(n - 1) + dp(n - 2));
        }
        return memo.get(n);
    }
}