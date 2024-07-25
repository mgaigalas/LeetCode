/**
 * Solution class contains solution for LeetCode problem:
 * #1176. Diet Plan Performance.
 *
 * @author Marius Gaigalas on 25/07/2024
 */
public class Solution {
    /**
     * Return the total number of points the dieter has after dieting for calories.length days.
     * Note that the total points can be negative.
     *
     * @param calories array of numbers indicating calories
     * @param k        consecutive sequence of days
     * @param lower    lower bound
     * @param upper    upper bound
     * @return total number of points
     */
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int pts = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < calories.length) {
            sum += calories[right];
            if (right - left + 1 != k) {
                right++;
                continue;
            }

            if (sum > upper) {
                pts++;
            } else if (sum < lower) {
                pts--;
            }
            sum -= calories[left];
            left++;
            right++;
        }
        return pts;
    }
}