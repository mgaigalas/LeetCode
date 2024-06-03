import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #1200. Minimum Absolute Difference.
 *
 * @author Marius Gaigalas on 02/06/2024
 */
public class Solution {
    /**
     * Given an array of distinct integers arr, finds all pairs of elements with the minimum
     * absolute difference of any two elements.
     * Returns a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
     * <ul>
     *     <li>a, b are from arr</li>
     *     <li>a < b</li>
     *     <li>b - a equals to the minimum absolute difference of any two elements in arr</li>
     * </ul>
     *
     * @param arr array of integers
     * @return list of pairs
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        var min = arr[0];
        var max = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        var shift = -min;
        final var counts = new int[max - min + 1];
        for (int num : arr) {
            counts[num + shift]++;
        }

        var prev = 0;
        var minSum = max - min;
        List<List<Integer>> res = new ArrayList<>();
        for (int curr = 1; curr <= max + shift; ++curr) {
            if (counts[curr] == 0) {
                continue;
            }

            if (curr - prev == minSum) {
                res.add(List.of(prev-shift, curr-shift));
            } else if (curr - prev < minSum) {
                res = new ArrayList<>();
                minSum = curr - prev;
                res.add(List.of(prev-shift, curr-shift));
            }
            prev = curr;
        }

        return res;
    }
}