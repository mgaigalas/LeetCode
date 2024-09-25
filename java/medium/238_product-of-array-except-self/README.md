# #238. Product of Array Except Self

<p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>

<p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [24,12,8,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
<strong>Output:</strong> [0,0,9,0,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
	<li>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)</code>&nbsp;extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>

## Notes

Optimized `O(1)` space complexity solution is an improvement over standard approach building two array with prefix sums 
from both ends of `nums` array

```java
/**
 * Solution class contains solution for LeetCode problem:
 * #238. Product of Array Except Self.
 *
 * @author Marius Gaigalas on 25/09/2024
 */
public class Solution {
    /**
     * Given an integer array nums, returns an array answer such that answer[i] is equal to the product of all the
     * elements of nums except nums[i].
     * Note: The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * @param nums array of integers
     * @return product of all the elements of nums except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        final int length = nums.length;

        final int[] L = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1]; // nums[i-1] - all nums up to i (exclusive)
        }

        final int[] R = new int[length];
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1]; // nums[i+1] - all nums from i (exclusive)
        }

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
```