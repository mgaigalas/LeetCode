import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution class contains solution for LeetCode problem:
 * #2696. Minimum String Length After Removing Substrings.
 *
 * @author Marius Gaigalas on 18/07/2024
 */
public class Solution {
    /**
     * Returns the minimum possible length of the resulting string that can be obtained.
     *
     * @param s string
     * @return minimum length
     */
    public int minLength(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            var curr = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            }

            var peek = stack.peek();
            if ((curr == 'D' && peek == 'C') || (curr == 'B' && peek == 'A')) {
                stack.pop();
                continue;
            }
            stack.push(curr);
        }
        return stack.size();
    }
}