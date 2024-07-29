import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #3. Longest Substring Without Repeating Characters.
 *
 * @author Marius Gaigalas on 29/07/2024
 */
public class Solution {
    /**
     * Given a string s, finds the length of the longest substring without repeating characters.
     *
     * @param s string
     * @return length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        final Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return res;
    }
}