# #3062. Winner of the Linked List Game

<p>You are given the <code>head</code> of a linked list of <strong>even</strong> length containing integers.</p>

<p>Each <strong>odd-indexed</strong> node contains an odd integer and each <strong>even-indexed</strong> node contains an even integer.</p>

<p>We call each even-indexed node and its next node a <strong>pair</strong>, e.g., the nodes with indices <code>0</code> and <code>1</code> are a pair, the nodes with indices <code>2</code> and <code>3</code> are a pair, and so on.</p>

<p>For every <strong>pair</strong>, we compare the values of the nodes in the pair:</p>

<ul>
	<li>If the odd-indexed node is higher, the <code>"Odd"</code> team gets a point.</li>
	<li>If the even-indexed node is higher, the <code>"Even"</code> team gets a point.</li>
</ul>

<p>Return <em>the name of the team with the <strong>higher</strong> points, if the points are equal, return</em> <code>"Tie"</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1: </strong></p>

<p><strong>Input: </strong>head = [2,1]</p>

<p><strong>Output: </strong>"Even"</p>

<p><strong>Explanation: </strong> There is only one pair in this linked list and that is <code>(2,1)</code>. Since <code>2 &gt; 1</code>, the Even team gets the point.</p>

<p>Hence, the answer would be <code>"Even"</code>.</p>

<p><strong class="example">Example 2: </strong></p>

<p><strong>Input: </strong>head = [2,5,4,7,20,5]</p>

<p><strong>Output: </strong>"Odd"</p>

<p><strong>Explanation: </strong> There are <code>3</code> pairs in this linked list. Let's investigate each pair individually:</p>

<p><code>(2,5)</code> -&gt; Since <code>2 &lt; 5</code>, The Odd team gets the point.</p>

<p><code>(4,7)</code> -&gt; Since <code>4 &lt; 7</code>, The Odd team gets the point.</p>

<p><code>(20,5)</code> -&gt; Since <code>20 &gt; 5</code>, The Even team gets the point.</p>

<p>The Odd team earned <code>2</code> points while the Even team got <code>1</code> point and the Odd team has the higher points.</p>

<p>Hence, the answer would be <code>"Odd"</code>.</p>

<p><strong class="example">Example 3: </strong></p>

<p><strong>Input: </strong>head = [4,5,2,1]</p>

<p><strong>Output: </strong>"Tie"</p>

<p><strong>Explanation: </strong> There are <code>2</code> pairs in this linked list. Let's investigate each pair individually:</p>

<p><code>(4,5)</code> -&gt; Since <code>4 &lt; 5</code>, the Odd team gets the point.</p>

<p><code>(2,1)</code> -&gt; Since <code>2 &gt; 1</code>, the Even team gets the point.</p>

<p>Both teams earned <code>1</code> point.</p>

<p>Hence, the answer would be <code>"Tie"</code>.</p>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[2, 100]</code>.</li>
	<li>The number of nodes in the list is even.</li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
	<li>The value of each odd-indexed node is odd.</li>
	<li>The value of each even-indexed node is even.</li>
</ul>