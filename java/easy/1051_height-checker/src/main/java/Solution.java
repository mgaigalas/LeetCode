/**
 * Solution class contains solution for LeetCode problem:
 * #1051. Height Checker.
 *
 * @author Marius Gaigalas on 23/05/2024
 */
public class Solution {
    /**
     * Given an integer array heights representing the current order that the students are standing in and each
     * heights[i] is the height of the ith student in line (0-indexed), returns the number of indices where
     * heights[i] != expected[i].
     *
     * @param heights an array of heights
     * @return number of indices where heights[i] != expected[i]
     */
    public int heightChecker(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        var arr = heights.clone();

        var res = 0;
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    hasSwapped = true;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}