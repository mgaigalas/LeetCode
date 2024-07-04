/**
 * Solution class contains solution for LeetCode problem:
 * #125. Valid Palindrome.
 *
 * @author Marius Gaigalas on 02/07/2024
 */
public class Solution {
    /**
     * Given a string s, returns true if it is a palindrome, or false otherwise.
     *
     * @param s string
     * @return true if it is a palindrome, or false otherwise
     */
    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}