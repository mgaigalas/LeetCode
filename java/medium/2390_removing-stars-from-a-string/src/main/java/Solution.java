import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution class contains solution for LeetCode problem:
 * #2390. Removing Stars From a String.
 *
 * @author Marius Gaigalas on 06/08/2024
 */
public class Solution {
    /**
     * Returns the string after all stars have been removed.
     *
     * @param s string
     * @return string after all stars have been removed
     */
    public String removeStars(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (var c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        final var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}