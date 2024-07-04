# #125. Valid Palindrome

<p>A phrase is a <strong>palindrome</strong> if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.</p>

<p>Given a string <code>s</code>, return <code>true</code><em> if it is a <strong>palindrome</strong>, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "A man, a plan, a canal: Panama"
<strong>Output:</strong> true
<strong>Explanation:</strong> "amanaplanacanalpanama" is a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "race a car"
<strong>Output:</strong> false
<strong>Explanation:</strong> "raceacar" is not a palindrome.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = " "
<strong>Output:</strong> true
<strong>Explanation:</strong> s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of printable ASCII characters.</li>
</ul>

## Notes

Solution without using `java.lang.Character` API

```java
/**
 * Solution class contains solution for LeetCode problem:
 * #125. Valid Palindrome.
 *
 * @author Marius Gaigalas on 02/07/2024
 */
public class Solution {
    /**
     * Given a string s, returns true if it is a palindrome, or false otherwise.
     *
     * @param s string
     * @return true if it is a palindrome, or false otherwise
     */
    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }

            if (toLowercase(s.charAt(left)) != toLowercase(s.charAt(right))) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isAlphanumeric(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }

    private int toLowercase(char c) {
        if ('A' <= c && c <= 'Z') {
            return c - 'A' + 'a';
        }
        return c;
    }
}
```