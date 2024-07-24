import java.util.HashSet;
import java.util.Set;

/**
 * Solution class contains solution for LeetCode problem:
 * #219. Contains Duplicate II.
 *
 * @author Marius Gaigalas on 24/07/2024
 */
public class Solution {
    /**
     * Given an integer array nums and an integer k, returns true if there are two distinct indices i and j in
     * the array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * @param nums array of nums
     * @param k    window size
     * @return flag indicating f there are two distinct indices i and j
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}