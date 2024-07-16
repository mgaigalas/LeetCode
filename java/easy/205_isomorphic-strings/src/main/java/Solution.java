import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #205. Isomorphic Strings.
 *
 * @author Marius Gaigalas on 16/07/2024
 */
public class Solution {
    /**
     * Given two strings s and t, determines if they are isomorphic.
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * @param s string
     * @param t string
     * @return flag indicating if both strings are isomorphic
     */
    public boolean isIsomorphic(String s, String t) {
        final Map<Character, Character> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);
            if (!dict.containsKey(sChar)) {
                if (dict.containsValue(tChar)) {
                    return false;
                }
                dict.put(sChar, tChar);
                continue;
            }

            if (dict.get(sChar) != tChar) {
                return false;
            }
        }
        return true;
    }
}