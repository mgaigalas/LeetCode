# #66. Plus One

<p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading <code>0</code>'s.</p>

<p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> digits = [1,2,3]
<strong>Output:</strong> [1,2,4]
<strong>Explanation:</strong> The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> digits = [4,3,2,1]
<strong>Output:</strong> [4,3,2,2]
<strong>Explanation:</strong> The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> digits = [9]
<strong>Output:</strong> [1,0]
<strong>Explanation:</strong> The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 100</code></li>
	<li><code>0 &lt;= digits[i] &lt;= 9</code></li>
	<li><code>digits</code> does not contain any leading <code>0</code>'s.</li>
</ul>

## Notes

Current solution can be rewritten in more standard approach using list and then reversing it

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Solution class contains solution for LeetCode problem:
 * #66. Plus One.
 *
 * @author Marius Gaigalas on 10/07/2024
 */
public class Solution {
    /**
     * Given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer.
     * The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increments the large integer by one and returns the resulting array of digits.
     *
     * @param digits number in a form of array
     * @return result number in a form of array
     */
    public int[] plusOne(int[] digits) {
        var n = digits.length - 1;
        var carry = false;

        final List<Integer> list = new ArrayList<>();
        while (n >= 0 || carry) {
            var digit = toDigitWithIndex(digits, n);
            if (n == digits.length - 1) {
                digit++;
            }

            if (carry) {
                digit++;
                carry = false;
            }

            if (digit > 9) {
                carry = true;
            }
            list.add(digit % 10);
            n--;
        }

        return list.reversed().stream()
                .mapToInt(value -> value)
                .toArray();
    }

    private static int toDigitWithIndex(int[] digits, int idx) {
        if (idx < 0) {
            return 0;
        }
        return digits[idx];
    }
}
```