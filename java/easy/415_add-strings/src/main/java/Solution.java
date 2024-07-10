/**
 * Solution class contains solution for LeetCode problem:
 * #415. Add Strings.
 *
 * @author Marius Gaigalas on 09/07/2024
 */
public class Solution {
    /**
     * Given two non-negative integers, num1 and num2 represented as string,
     * returns the sum of num1 and num2 as a string.
     *
     * @param num1 first number as a string
     * @param num2 second number as a string
     * @return sum of two numbers as a string
     */
    public String addStrings(String num1, String num2) {
        final var sb = new StringBuilder();
        var n = num1.length() - 1;
        var m = num2.length() - 1;
        var carry = false;
        while (n >= 0 || m >= 0 || carry) {
            var digit1 = toDigitAtIndex(num1, n);
            var digit2 = toDigitAtIndex(num2, m);

            int sum = digit1 + digit2;
            if (carry) {
                sum++;
                carry = false;
            }

            if (sum > 9) {
                carry = true;
            }
            sb.append(sum % 10);
            n--;
            m--;
        }
        return sb.reverse().toString();
    }

    /**
     * Converts single character at provided index into int.
     *
     * @param str string containing digits-only
     * @param idx index at which digit should be read from
     * @return single digit
     */
    private static int toDigitAtIndex(String str, int idx) {
        if (idx < 0) {
            return 0;
        }
        return str.charAt(idx) - '0';
    }
}