/**
 * Solution class contains solution for LeetCode problem:
 * #3206. Alternating Groups I.
 *
 * @author Marius Gaigalas on 12/08/2024
 */
public class Solution {
    /**
     * Returns the number of alternating groups.
     *
     * @param colors array of integers
     * @return number of alternating groups
     */
    public int numberOfAlternatingGroups(int[] colors) {
        final int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int mid = (i + 1) % n;
            int right = (i + 2) % n;
            if (colors[i] == colors[right] && colors[i] != colors[mid]) {
                res++;
            }
        }
        return res;
    }
}