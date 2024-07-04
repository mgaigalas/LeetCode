# #20. Valid Parentheses

<p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "()"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "()[]{}"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "(]"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li>
</ul>

## Notes

Solution without explicit dictionary

```java
import java.util.ArrayDeque;
import java.util.Deque;

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
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            char sc = stack.pop();
            if ((c == ')' && sc != '(') || (c == '}' && sc != '{') || (c == ']' && sc != '[')) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
```