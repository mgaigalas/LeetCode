import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #47. Permutations II.
 *
 * @author Marius Gaigalas on 18/07/2024
 */
public class Solution {
    /**
     * Given a collection of numbers, nums, that might contain duplicates,
     * returns all possible unique permutations in any order.
     *
     * @param nums integer array
     * @return list of permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        final Map<Integer, Integer> state = new HashMap<>();
        for (int num : nums) {
            state.put(num, state.getOrDefault(num, 0) + 1);
        }

        final List<List<Integer>> res = new ArrayList<>();
        backtrack(new LinkedList<>(), state, nums.length, res);
        return res;
    }

    /**
     * Backtrack method for generating permutation.
     *
     * @param curr  current state (pending permutation)
     * @param state counter containing info about available items for current and next iteration
     * @param n     size of current state permutation at which it should be completed
     * @param res   result containing all permutations
     */
    private void backtrack(List<Integer> curr, Map<Integer, Integer> state, int n, List<List<Integer>> res) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (var entry : state.entrySet()) {
            var key = entry.getKey();
            var val = entry.getValue();
            if (val == 0) {
                continue;
            }

            state.put(key, val - 1);
            curr.add(key);
            backtrack(curr, state, n, res);
            curr.removeLast();
            state.put(key, val);
        }
    }
}