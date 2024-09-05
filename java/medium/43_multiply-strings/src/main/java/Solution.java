/**
 * Solution class contains solution for LeetCode problem:
 * #43. Multiply Strings.
 *
 * @author Marius Gaigalas on 27/08/2024
 */
public class Solution {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, returns the product of num1 and num2,
     * also represented as a string.
     *
     * @param num1 first number as a String
     * @param num2 second number as a String
     * @return multiplication result as a String
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        final int n = num1.length();
        final int m = num2.length();

        final int[] arr = new int[n + m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i + j] = arr[i + j] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i - 1] = arr[i - 1] + arr[i] / 10;
            arr[i] = arr[i] % 10;
        }

        final StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val);
        }
        return sb.toString();
    }
}