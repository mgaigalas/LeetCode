/**
 * Solution class contains solution for LeetCode problem:
 * #3090. Maximum Length Substring With Two Occurrences.
 *
 * @author Marius Gaigalas on 12/08/2024
 */
public class Solution {
    /**
     * Return the maximum length of a substring such that it contains at most two occurrences of each character.
     *
     * @param s input string
     * @return maximum length of a substring such that it contains at most two occurrences of each character
     */
    public int maximumLengthSubstring(String s) {
        final int[] map = new int[26];
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            int rightChar = s.charAt(right) - 'a';
            map[rightChar]++;
            while (map[rightChar] > 2) {
                map[s.charAt(left) - 'a']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}