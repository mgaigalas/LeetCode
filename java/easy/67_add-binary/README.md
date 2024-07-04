# #67. Add Binary

<p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = "11", b = "1"
<strong>Output:</strong> "100"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = "1010", b = "1011"
<strong>Output:</strong> "10101"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
	<li><code>a</code> and <code>b</code> consist&nbsp;only of <code>'0'</code> or <code>'1'</code> characters.</li>
	<li>Each string does not contain leading zeros except for the zero itself.</li>
</ul>

## Notes

Bit manipulation is required for this solution. Bit manipulation consists of following operations:
<ol>
    <li>OR <code>|</code> - if any bit is 1, then the result will be 1. Otherwise, the result is 0</li>
    <li>AND <code>&</code> - if all bits are 1, then the result will be 1. Otherwise, the result is 0</li>
    <li>XOR <code>^</code> - if the number of 1 bits is odd, then the result will be 1. Otherwise, the result is 0</li>
    <li>Left and right shifts: <code><<, >></code> - shifts move all bits over one place in the respective direction. 
        If the first bit is flipped, a right shift will "delete" it. Shifts correspond to multiplying or 
        dividing a number by 2. (Left shift = multiply by 2, right shift = floor division by 2)</li>
</ol>

Overall approach is:
<ol>
    <li><code>x XOR y</code> - get non overlapping 1 bits</li>
    <li><code>(x AND y) << 1</code> - calculate carry and shift it by 1 position to left 
    (i.e. <code>(01 & 01) << 1 = 10</code>, which indicates carry for next iteration)</li>
    <li>repeat 1 and 2 until carry is zero each time updating the answer as part of input (x-var)</li>
</ol>

<code>
case 1: 11 + 1<br />
==================<br />
x = 11<br />
y = 01<br />
<br />
answer = 11 XOR 01 = 10<br />
carry = (11 AND 01) << 1 = 01 << 1 = 10<br />
==================<br />
x = 10<br />
y = 10<br />
<br />
answer = 10 XOR 10 = 0<br />
carry = (10 AND 10) << 1 = 10 << 1 = 100<br />
==================<br />
x = 0<br />
y = 100<br />
<br />
answer = 0 XOR 100 = 100<br />
carry = (0 AND 100) << 1 = 0 << 1 = 0<br />
==================<br />
x = 100<br />
y = 0<br />
</code>