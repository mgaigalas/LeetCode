import java.math.BigInteger;

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
        var x = new BigInteger(a, 2);
        var y = new BigInteger(b, 2);
        while (!y.equals(BigInteger.ZERO)) {
            var answer = x.xor(y);
            var carry = (x.and(y)).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}