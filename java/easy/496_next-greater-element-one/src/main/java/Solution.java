import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #496. Next Greater Element I.
 *
 * @author Marius Gaigalas on 02/08/2024
 */
public class Solution {
    /**
     * Returns an array ans of length nums1.length such that ans[i] is the next greater element as described in a
     * problem description.
     *
     * @param nums1 array of integers (sub-set of nums2)
     * @param nums2 array of integers (super-set of nums1)
     * @return array of integers containing next greater elements
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        final int[] res = new int[nums1.length];

        final Map<Integer, Integer> nextMap = new HashMap<>();
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nextMap.containsKey(nums1[i])) {
                res[i] = nextMap.get(nums1[i]);
                continue;
            }
            res[i] = -1;
        }
        return res;
    }
}