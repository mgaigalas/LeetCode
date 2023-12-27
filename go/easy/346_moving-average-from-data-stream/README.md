# #346. Moving Average from Data Stream

<p>Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.</p>

<p>Implement the&nbsp;<code>MovingAverage</code> class:</p>

<ul>
	<li><code>MovingAverage(int size)</code> Initializes&nbsp;the object with the size of the window <code>size</code>.</li>
	<li><code>double next(int val)</code> Returns the moving average of the last <code>size</code> values of the stream.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
<strong>Output</strong>
[null, 1.0, 5.5, 4.66667, 6.0]

<strong>Explanation</strong>
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= size &lt;= 1000</code></li>
	<li><code>-10<sup>5</sup> &lt;= val &lt;= 10<sup>5</sup></code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>next</code>.</li>
</ul>

## Notes

Go has no explicit implementation of a queue, therefore this problem can be solved with 
either slices (like in solution, where I am using slice as a circular queue), or representations of a linked list:

```go
// Package movingavgfromdatastream contains solution for LeetCode problem: #346. Moving Average from Data Stream.
package movingavgfromdatastream

// ListNode is a struct representing singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// MovingAverage contains buffer (used as a queue) and index of a last element.
type MovingAverage struct {
	Size    int
	Counter int
	Head    *ListNode
	List    *ListNode
}

// Constructor creates and returns new instance of MovingAverage.
func Constructor(size int) MovingAverage {
	node := &ListNode{
		Val:  0,
		Next: nil,
	}
	return MovingAverage{
		Size: size,
		Head: node,
		List: node,
	}
}

// Next puts next value into a queue, calculates and returns average of all elements in a queue.
func (this *MovingAverage) Next(val int) float64 {
	this.List.Next = &ListNode{
		Val:  val,
		Next: nil,
	}
	this.Counter++
	this.List = this.List.Next

	if this.Counter >= this.Size {
		this.Counter = this.Size
		this.Head = this.Head.Next
	}

	var sum int
	node := this.Head
	for node != nil {
		sum += node.Val
		node = node.Next
	}

	return float64(sum) / float64(this.Counter)
}
```