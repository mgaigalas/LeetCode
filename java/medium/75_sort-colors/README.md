# #75. Sort Colors

<p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library's sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>

## Notes

Solution using Counting Sort

```java
import java.util.Arrays;

/**
 * Solution class contains solution for LeetCode problem:
 * #75. Sort Colors.
 *
 * @author Marius Gaigalas on 29/05/2024
 */
public class Solution {
    /**
     * Given an array nums with n objects, returns sorted in-place objects.
     *
     * @param nums an array of integers
     */
    @SuppressWarnings({"OptionalGetWithoutIsPresent", "ManualArrayCopy"})
    public void sortColors(int[] nums) {
        final var K = Arrays.stream(nums).max().getAsInt();
        final var counts = new int[K+1];
        for (int num : nums) {
            counts[num]++;
        }

        var startingIndex = 0;
        for (int i = 0; i < K + 1; i++) {
            var count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        final var sortedArr = new int[nums.length];
        for (int num : nums) {
            sortedArr[counts[num]] = num;
            counts[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sortedArr[i];
        }
    }
}
```