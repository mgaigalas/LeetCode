import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #1. Two Sum.
 *
 * @author Marius Gaigalas on 04/07/2024
 */
public class Solution {
    /**
     * Given a pattern and a string s, finds if s follows the same pattern.
     *
     * @param pattern word pattern
     * @param s       string containing words separated by " " symbol
     * @return flag, which indicates if string adheres pattern
     */
    public boolean wordPattern(String pattern, String s) {
        final Map<Character, String> dictionary = new HashMap<>();
        final String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            var value = dictionary.get(key);
            if (value == null) {
                value = words[i];
                if (dictionary.containsValue(value)) {
                    return false;
                }
                dictionary.put(key, value);
                continue;
            }

            if (!value.equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}