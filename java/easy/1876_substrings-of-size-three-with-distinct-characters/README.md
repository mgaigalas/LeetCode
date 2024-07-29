# #1876. Substrings of Size Three with Distinct Characters

<p>A string is <strong>good</strong> if there are no repeated characters.</p>

<p>Given a string <code>s</code>, return <em>the number of <strong>good substrings</strong> of length <strong>three </strong>in </em><code>s</code>.</p>

<p>Note that if there are multiple occurrences of the same substring, every occurrence should be counted.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters in a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "xyzzaz"
<strong>Output:</strong> 1
<strong>Explanation:</strong> There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aababcabc"
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

## Notes

Standard way of solving this problem is with a Sliding Window

```java
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class contains solution for LeetCode problem:
 * #1876. Substrings of Size Three with Distinct Characters.
 *
 * @author Marius Gaigalas on 29/07/2024
 */
public class Solution {
    /**
     * Given a string s, returns the number of good substrings of length three in s.
     *
     * @param s string
     * @return number of good substrings of length three
     */
    public int countGoodSubstrings(String s) {
        int res = 0;
        final Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);

            while (map.get(rc) > 1) {
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                left++;
            }

            if (right - left + 1 == 3) {
                map.remove(s.charAt(left));
                left++;
                res++;
            }
        }
        return res;
    }
}
```