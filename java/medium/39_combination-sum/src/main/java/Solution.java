import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #39. Combination Sum.
 *
 * @author Marius Gaigalas on 13/07/2024
 */
public class Solution {
    /**
     * Given an array of distinct integers candidates and a target integer target, returns a list of all
     * unique combinations of candidates where the chosen numbers sum to target.
     *
     * @param candidates array containing all available numbers
     * @param target     target sum
     * @return list containing all possible combinations
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), candidates, 0, target, res);
        return res;
    }

    /**
     * Backtrack utility method, which searches candidates for a combination. If found - appends result.
     *
     * @param curr       list containing current state of candidate search
     * @param candidates array containing all available numbers
     * @param idx        index from which to start search in candidates array
     * @param target     target sum
     * @param res        final result list containing all possible combinations
     */
    private static void backtrack(List<Integer> curr, int[] candidates, int idx, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            curr.add(candidates[i]);
            backtrack(curr, candidates, i, target - candidates[i], res);
            curr.removeLast();
        }
    }
}