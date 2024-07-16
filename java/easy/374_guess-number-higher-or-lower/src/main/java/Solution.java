/**
 * Solution class contains solution for LeetCode problem:
 * #374. Guess Number Higher or Lower.
 *
 * @author Marius Gaigalas on 13/07/2024
 */
public class Solution extends GuessGame {
    public Solution(int result) {
        super(result);
    }

    /**
     * Based on guess n returns if n is number that user is guessing.
     *
     * @param n guess as a number
     * @return actual number
     */
    public int guessNumber(int n) {
        var low = 1;
        var high = n;
        while (low <= high) {
            var mid = low + (high - low) / 2;
            var guess = this.guess(mid);
            if (guess == 0) {
                return mid;
            }

            if (guess < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}