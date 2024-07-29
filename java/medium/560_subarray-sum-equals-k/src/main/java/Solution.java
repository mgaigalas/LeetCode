import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #560. Subarray Sum Equals K.
 *
 * @author Marius Gaigalas on 29/07/2024
 */
public class Solution {
    /**
     * Given an array of integers nums and an integer k, returns the total number of sub-arrays whose sum equals to k.
     *
     * @param nums array of integers
     * @param k    target sum
     * @return total number of sub-arrays whose sum equals to k
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}