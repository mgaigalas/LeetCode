/**
 * GuessGame class containing API for LeetCode problem:
 * #374. Guess Number Higher or Lower.
 * NOTE: this class was provided by LeetCode.
 *
 * @author Marius Gaigalas on 13/07/2024
 */
public class GuessGame {
    private final int result;

    public GuessGame(int result) {
        this.result = result;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     */
    int guess(int num) {
        if (num == result) {
            return 0;
        }
        return num > result ? -1 : 1;
    }
}