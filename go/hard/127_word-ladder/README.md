# #127. Word Ladder

<p>A <strong>transformation sequence</strong> from word <code>beginWord</code> to word <code>endWord</code> using a dictionary <code>wordList</code> is a sequence of words <code>beginWord -&gt; s<sub>1</sub> -&gt; s<sub>2</sub> -&gt; ... -&gt; s<sub>k</sub></code> such that:</p>

<ul>
	<li>Every adjacent pair of words differs by a single letter.</li>
	<li>Every <code>s<sub>i</sub></code> for <code>1 &lt;= i &lt;= k</code> is in <code>wordList</code>. Note that <code>beginWord</code> does not need to be in <code>wordList</code>.</li>
	<li><code>s<sub>k</sub> == endWord</code></li>
</ul>

<p>Given two words, <code>beginWord</code> and <code>endWord</code>, and a dictionary <code>wordList</code>, return <em>the <strong>number of words</strong> in the <strong>shortest transformation sequence</strong> from</em> <code>beginWord</code> <em>to</em> <code>endWord</code><em>, or </em><code>0</code><em> if no such sequence exists.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
<strong>Output:</strong> 5
<strong>Explanation:</strong> One shortest transformation sequence is "hit" -&gt; "hot" -&gt; "dot" -&gt; "dog" -&gt; cog", which is 5 words long.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= beginWord.length &lt;= 10</code></li>
	<li><code>endWord.length == beginWord.length</code></li>
	<li><code>1 &lt;= wordList.length &lt;= 5000</code></li>
	<li><code>wordList[i].length == beginWord.length</code></li>
	<li><code>beginWord</code>, <code>endWord</code>, and <code>wordList[i]</code> consist of lowercase English letters.</li>
	<li><code>beginWord != endWord</code></li>
	<li>All the words in <code>wordList</code> are <strong>unique</strong>.</li>
</ul>

## Notes

Another way to solve this by not building adjacency dictionary is building entire list of probable candidates

```go
// Package wordladder contains solution for LeetCode problem: #2101. Detonate the Maximum Bombs.
package wordladder

import "strings"

// State contains data about current step within BFS.
type State struct {
	word  string
	turns int
}

// ladderLength returns the number of words in the shortest transformation sequence from beginWord to endWord,
// or 0 if no such sequence exists.
func ladderLength(beginWord string, endWord string, wordList []string) int {
	whitelist := make(map[string]struct{}, len(wordList))
	for _, word := range wordList {
		whitelist[word] = struct{}{}
	}
	queue := make([]*State, 1, len(wordList))
	queue[0] = &State{
		word:  beginWord,
		turns: 1, // this is required as initial word is counted as "initial step"
	}
	seen := make(map[string]struct{}, len(wordList))
	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]
		sourceWord := state.word
		if sourceWord == endWord {
			return state.turns
		}
		seen[sourceWord] = struct{}{}
		for i := 0; i < len(sourceWord); i++ {
			for j := 0; j < 26; j++ {
				var sb strings.Builder
				sb.WriteString(sourceWord[0:i])
				sb.WriteRune(rune(j + 'a'))
				sb.WriteString(sourceWord[i+1:])
				nextWord := sb.String()
				if _, exists := whitelist[nextWord]; !exists {
					continue
				}
				if _, exists := seen[nextWord]; exists {
					continue
				}
				seen[nextWord] = struct{}{}
				queue = append(queue, &State{
					word:  nextWord,
					turns: state.turns + 1,
				})
			}
		}
	}
	return 0
}
```