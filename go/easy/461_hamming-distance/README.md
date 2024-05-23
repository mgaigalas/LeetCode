# #461. Hamming Distance

<p>The <a href="https://en.wikipedia.org/wiki/Hamming_distance" target="_blank">Hamming distance</a> between two integers is the number of positions at which the corresponding bits are different.</p>

<p>Given two integers <code>x</code> and <code>y</code>, return <em>the <strong>Hamming distance</strong> between them</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 1, y = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong>
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 3, y = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;=&nbsp;x, y &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

## Notes

Optimized solution, which ignores checking if right-most (first) bit is 1

```go
// Package hammingdistance contains solution for LeetCode problem: #461. Hamming Distance.
package hammingdistance

// hammingDistance calculates hamming distance between x and y integer numbers.
// Humming Distance - how many bits are different between two numbers.
func hammingDistance(x int, y int) int {
	// XOR "removes" bits that are the same.
	xor, distance := x^y, 0
	for xor != 0 {
		// AND 1 returns always 1 if right most bit is also 1.
		//  We are counting XOR bits that are non-zero.
		distance = distance + (xor & 1)
		// After each operation - we shift all bits one spot to right, thus truncating the beginning.
		xor = xor >> 1
	}
	return distance
}
```