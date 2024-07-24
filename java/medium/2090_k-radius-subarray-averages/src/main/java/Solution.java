import java.util.Arrays;

/**
 * Solution class contains solution for LeetCode problem:
 * #2090. K Radius Subarray Averages.
 *
 * @author Marius Gaigalas on 24/07/2024
 */
public class Solution {
    /**
     * Builds and returns an array avgs of length n where avgs[i] is the k-radius average for the subarray
     * centered at index i.
     *
     * @param nums array of numbers
     * @param k    as center of radius
     * @return an array avgs
     */
    public int[] getAverages(int[] nums, int k) {
        final var res = new int[nums.length];
        final long radius = 2L * k + 1L;
        if (nums.length < radius) {
            Arrays.fill(res, -1);
            return res;
        }

        long sum = 0L;
        for (int i = 0; i < radius - 1; i++) {
            res[i] = -1;
            sum += nums[i];
        }

        for (int i = k; i < nums.length - k; i++) {
            sum += nums[i + k];
            res[i] = (int) (sum / radius);
            sum -= nums[i - k];
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            res[i] = -1;
        }

        return res;
    }
}