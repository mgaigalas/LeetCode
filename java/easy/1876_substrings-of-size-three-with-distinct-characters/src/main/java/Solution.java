/**
 * Solution class contains solution for LeetCode problem:
 * #1876. Substrings of Size Three with Distinct Characters.
 *
 * @author Marius Gaigalas on 29/07/2024
 */
public class Solution {
    /**
     * Given a string s, returns the number of good substrings of length three in s.
     *
     * @param s string
     * @return number of good substrings of length three
     */
    public int countGoodSubstrings(String s) {
        int res = 0;
        final char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] != arr[i + 1] && arr[i + 1] != arr[i + 2] && arr[i] != arr[i + 2]) {
                res++;
            }
        }
        return res;
    }
}