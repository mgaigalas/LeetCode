/**
 * Solution class contains solution for LeetCode problem:
 * #1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold.
 *
 * @author Marius Gaigalas on 31/07/2024
 */
public class Solution {
    /**
     * Returns the number of sub-arrays of size k and average greater than or equal to threshold.
     *
     * @param arr       array of integers
     * @param k         size of sub-arrays
     * @param threshold average threshold
     * @return numbers of sub-arrays
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }

        for (int right = k - 1, left = 0; right < arr.length; right++) {
            sum += arr[right];
            if (right - left + 1 > k) {
                sum -= arr[left];
                left++;
            }

            if (sum / k >= threshold) {
                res++;
            }
        }
        return res;
    }
}