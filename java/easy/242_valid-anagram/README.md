# #242. Valid Anagram

<p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code> if <code>t</code> is an anagram of <code>s</code>, and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "anagram", t = "nagaram"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "rat", t = "car"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>t</code> consist of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> What if the inputs contain Unicode characters? How would you adapt your solution to such a case?</p>

## Notes

Since <code>s</code> and <code>t</code> lengths should be same in order even test if <code>t</code> is an anagram of 
<code>s</code> both strings can be processed at a same loop

```java
/**
 * Solution class contains solution for LeetCode problem:
 * #242. Valid Anagram.
 *
 * @author Marius Gaigalas on 06/08/2024
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
            arr[t.charAt(i) - 'a']--;
        }

        for (int val : arr) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
```