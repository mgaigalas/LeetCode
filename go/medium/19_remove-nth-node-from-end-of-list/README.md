# #19. Remove Nth Node From End of List

<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="ex1.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>

## Notes

Other way to do this with sentinel node with same time and space complexity:

```go
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	sentinel := &ListNode{
		Val: -1,
		Next: head,
	}
	prev := findPreNode(sentinel, n)
	if prev.Next.Next == nil {
		prev.Next = nil
	} else {
		prev.Next = prev.Next.Next
	}
	return sentinel.Next
}

func findPreNode(node *ListNode, pos int) *ListNode {
	currPos, pre := 1, node
	for node != nil {
		if currPos - pos - 1 > 0 {
			pre = pre.Next
		}
		node = node.Next
		currPos++
	}
	return pre
}
```