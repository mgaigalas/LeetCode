# #17. Letter Combinations of a Phone Number

<p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
<img alt="" src="ex1.png" style="width: 300px; height: 243px;">
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> digits = "23"
<strong>Output:</strong> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> digits = ""
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> digits = "2"
<strong>Output:</strong> ["a","b","c"]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= digits.length &lt;= 4</code></li>
	<li><code>digits[i]</code> is a digit in the range <code>['2', '9']</code>.</li>
</ul>

## Notes

Standard way to solve this would be by using string builder

```go
// Package lettercombinationsofphonenumber contains solution for LeetCode problem:
// #17. Letter Combinations of a Phone Number.
package lettercombinationsofphonenumber

import "strings"

// letterCombinations given a string containing digits from 2-9 inclusive, returns all possible letter combinations
// that the number could represent.
func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	dict := []string{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

	curr := make([]rune, 0)
	res := make([]string, 0)
	var backtrack func(i int)
	backtrack = func(i int) {
		if len(digits) == i {
			var sb strings.Builder
			for _, str := range curr {
				sb.WriteRune(str)
			}
			res = append(res, sb.String())
			return
		}

		num := int(digits[i] - '0')
		for _, char := range dict[num] {
			curr = append(curr, char)
			backtrack(i + 1)
			curr = curr[:len(curr)-1]
		}
	}
	backtrack(0)
	return res
}
```