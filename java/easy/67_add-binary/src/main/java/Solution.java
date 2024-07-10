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
        var carry = 0;

        var sb = new StringBuilder();
        while (n >= 0 || m >= 0 || carry > 0) {
            char aDigit = toCharDigitWithIndex(a, n);
            if (aDigit == '1') {
                carry++;
            }

            char bDigit = toCharDigitWithIndex(b, m);
            if (bDigit == '1') {
                carry++;
            }

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

    private static char toCharDigitWithIndex(String str, int idx) {
        if (idx < 0) {
            return '0';
        }
        return str.charAt(idx);
    }
}