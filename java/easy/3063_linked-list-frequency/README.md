# #3063. Linked List Frequency

<p>Given the <code>head</code> of a linked list containing <code>k</code> <strong>distinct</strong> elements, return <em>the head to a linked list of length </em><code>k</code><em> containing the frequency of each <strong>distinct</strong> element in the given linked list in <strong>any order</strong>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1: </strong></p>

<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> head = [1,1,2,1,2,3] </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> [3,2,1] </span></p>

<p><strong>Explanation: </strong> There are <code>3</code> distinct elements in the list. The frequency of <code>1</code> is <code>3</code>, the frequency of <code>2</code> is <code>2</code> and the frequency of <code>3</code> is <code>1</code>. Hence, we return <code>3 -&gt; 2 -&gt; 1</code>.</p>

<p>Note that <code>1 -&gt; 2 -&gt; 3</code>, <code>1 -&gt; 3 -&gt; 2</code>, <code>2 -&gt; 1 -&gt; 3</code>, <code>2 -&gt; 3 -&gt; 1</code>, and <code>3 -&gt; 1 -&gt; 2</code> are also valid answers.</p>

<p><strong class="example">Example 2: </strong></p>

<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> head = [1,1,2,2,2] </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> [2,3] </span></p>

<p><strong>Explanation: </strong> There are <code>2</code> distinct elements in the list. The frequency of <code>1</code> is <code>2</code> and the frequency of <code>2</code> is <code>3</code>. Hence, we return <code>2 -&gt; 3</code>.</p>

<p><strong class="example">Example 3: </strong></p>

<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> head = [6,5,4,3,2,1] </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;"> [1,1,1,1,1,1] </span></p>

<p><strong>Explanation: </strong> There are <code>6</code> distinct elements in the list. The frequency of each of them is <code>1</code>. Hence, we return <code>1 -&gt; 1 -&gt; 1 -&gt; 1 -&gt; 1 -&gt; 1</code>.</p>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>