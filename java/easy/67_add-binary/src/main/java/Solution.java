/**
 * Solution class contains solution for LeetCode problem:
 * #67. Add Binary.
 *
 * @author Marius Gaigalas on 03/07/2024
 */
public class Solution {
    /**
     * Given two binary strings a and b, returns their sum as a binary string.
     *
     * @param a binary numbers as a string
     * @param b binary numbers as a string
     * @return binary sum as a string
     */
    public String addBinary(String a, String b) {
        var n = a.length() - 1;
        var m = b.length() - 1;

        var sb = new StringBuilder();
        var carry = 0;
        while (n >= 0 || m >= 0 || carry > 0) {
            carry += toInt(a, n);
            carry += toInt(b, m);

            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }

            carry /= 2;
            n--;
            m--;
        }

        return sb.reverse().toString();
    }

    /**
     * Utility method for converting character from string to single int digit.
     *
     * @param str string containing numeric characters
     * @param idx index of digit to extract (can be negative)
     * @return single digit as a string
     */
    private static int toInt(String str, int idx) {
        if (idx < 0) {
            return 0;
        }
        return str.charAt(idx) - '0';
    }
}