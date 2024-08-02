import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #1475. Final Prices With a Special Discount in a Shop.
 *
 * @author Marius Gaigalas on 02/08/2024
 */
public class Solution {
    /**
     * Returns an integer array answer where answer[i] is the final price you will pay for the ith item of the shop,
     * considering the special discount.
     *
     * @param prices array of prices
     * @return array of final prices
     */
    public int[] finalPrices(int[] prices) {
        final int[] res = new int[prices.length];

        final Map<Integer, Integer> nextMap = new HashMap<>();
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                nextMap.put(stack.pop(), i);
            }
            stack.push(i);
        }

        for (int i = 0; i < prices.length; i++) {
            if (!nextMap.containsKey(i)) {
                res[i] = prices[i];
                continue;
            }
            res[i] = prices[i] - prices[nextMap.get(i)];
        }
        return res;
    }
}