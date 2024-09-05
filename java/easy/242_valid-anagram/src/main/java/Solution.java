/**
 * Solution class contains solution for LeetCode problem:
 * #242. Valid Anagram.
 *
 * @author Marius Gaigalas on 04/09/2024
 */
public class Solution {
    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * @param s first string
     * @param t second string
     * @return flag indicating if t is anagram of s
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i) - 'a';
            arr[c]--;
            if (arr[c] < 0) {
                return false;
            }
        }
        return true;
    }
}