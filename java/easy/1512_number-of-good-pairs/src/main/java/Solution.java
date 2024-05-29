import java.util.HashMap;

/**
 * Solution class contains solution for LeetCode problem:
 * #1512. Number of Good Pairs.
 *
 * @author Marius Gaigalas on 23/05/2024
 */
public class Solution {
    /**
     * Given an array of integers nums, returns the number of good pairs.
     *
     * @param nums an array of integers
     * @return number of good pairs
     */
    public int numIdenticalPairs(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var res = 0;
        for (var num : nums) {
            res += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return res;
    }
}