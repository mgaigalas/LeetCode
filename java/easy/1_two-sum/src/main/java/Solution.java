import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #1. Two Sum.
 *
 * @author Marius Gaigalas on 04/06/2024
 */
public class Solution {
    /**
     * Given an array of integers nums and an integer target,
     * returns indices of the two numbers such that they add up to target.
     *
     * @param nums   array of integers
     * @param target target sum
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}