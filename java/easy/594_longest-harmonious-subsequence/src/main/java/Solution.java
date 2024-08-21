import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #594. Longest Harmonious Subsequence.
 *
 * @author Marius Gaigalas on 21/08/2024
 */
public class Solution {
    /**
     * Given an integer array nums, returns the length of its longest harmonious subsequence among all
     * its possible subsequences.
     *
     * @param nums array of integers
     * @return length of longest harmonious subsequence
     */
    public int findLHS(int[] nums) {
        int res = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}