/**
 * Solution class contains solution for LeetCode problem:
 * #2379. Minimum Recolors to Get K Consecutive Black Blocks.
 *
 * @author Marius Gaigalas on 25/07/2024
 */
public class Solution {
    /**
     * Returns the minimum number of operations needed such that there is at least one occurrence of k
     * consecutive black blocks.
     *
     * @param blocks string containing color codes
     * @param k      desired number of consecutive black blocks
     * @return minimum number of operations
     */
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        final char[] arr = blocks.toCharArray();
        for (int i = 0; i < k; i++) {
            if (arr[i] == 'W') {
                count++;
            }
        }

        int res = count;
        int left = 1;
        int right = k;
        if (arr[0] == 'W') {
            count--;
        }

        while (right < blocks.length()) {
            if (arr[right] == 'W') {
                count++;
            }

            if (count < res) {
                res = count;
            }

            if (arr[left] == 'W') {
                count--;
            }
            left++;
            right++;
        }
        return res;
    }
}