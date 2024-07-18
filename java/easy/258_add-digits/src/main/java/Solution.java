/**
 * Solution class contains solution for LeetCode problem:
 * #258. Add Digits.
 *
 * @author Marius Gaigalas on 18/07/2024
 */
public class Solution {
    /**
     * Given an integer num, repeatedly adds all its digits until the result has only one digit, and returns it.
     *
     * @param num number
     * @return one digit result
     */
    public int addDigits(int num) {
        var res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;

            if (num == 0 && res > 9) {
                num = res;
                res = 0;
            }
        }
        return res;
    }
}