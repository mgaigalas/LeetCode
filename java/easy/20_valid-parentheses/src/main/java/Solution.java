import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #20. Valid Parentheses.
 *
 * @author Marius Gaigalas on 04/07/2024
 */
public class Solution {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determines if the input string is valid.
     * <p>
     * An input string is valid if:
     * <ol>
     *     <li>Open brackets must be closed by the same type of brackets.</li>
     *     <li>Open brackets must be closed in the correct order.</li>
     *     <li>Every close bracket has a corresponding open bracket of the same type.</li>
     * </ol>
     *
     * @param s input string
     * @return flag if string contains valid characters
     */
    public boolean isValid(String s) {
        final Map<Character, Character> dictionary = Map.of(
                '(', ')',
                '{', '}',
                '[', ']');
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            var dc = dictionary.get(c);
            if (dc != null) {
                stack.push(dc);
                continue;
            }

            if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}