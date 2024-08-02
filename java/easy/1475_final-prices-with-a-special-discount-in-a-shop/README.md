# #1475. Final Prices With a Special Discount in a Shop

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of the <code>i<sup>th</sup></code> item in a shop.</p>

<p>There is a special discount for items in the shop. If you buy the <code>i<sup>th</sup></code> item, then you will receive a discount equivalent to <code>prices[j]</code> where <code>j</code> is the minimum index such that <code>j &gt; i</code> and <code>prices[j] &lt;= prices[i]</code>. Otherwise, you will not receive any discount at all.</p>

<p>Return an integer array <code>answer</code> where <code>answer[i]</code> is the final price you will pay for the <code>i<sup>th</sup></code> item of the shop, considering the special discount.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> prices = [8,4,6,2,3]
<strong>Output:</strong> [4,2,4,2,3]
<strong>Explanation:</strong> 
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> [1,2,3,4,5]
<strong>Explanation:</strong> In this case, for all items, you will not receive any discount at all.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> prices = [10,1,1,6]
<strong>Output:</strong> [9,0,1,6]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 500</code></li>
	<li><code>1 &lt;= prices[i] &lt;= 1000</code></li>
</ul>

## Notes

Usual way to solve this problem is by using Monotonic stack to build map containing indexes of next (lower) value, 
however, since input length is so low `1 <= prices.length <= 500`, Brute Force will outperform overhead induced by 
Monotonic stack.

```java
/**
 * Solution class contains solution for LeetCode problem:
 * #1475. Final Prices With a Special Discount in a Shop.
 *
 * @author Marius Gaigalas on 02/08/2024
 */
public class Solution {
    /**
     * Returns an integer array answer where answer[i] is the final price you will pay for the ith item of the shop,
     * considering the special discount.
     *
     * @param prices array of prices
     * @return array of final prices
     */
    public int[] finalPrices(int[] prices) {
        final int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            var nextVal = -1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    nextVal = prices[i] - prices[j];
                    break;
                }
            }

            if (nextVal == -1) {
                res[i] = prices[i];
                continue;
            }
            res[i] = nextVal;
        }
        return res;
    }
}
```