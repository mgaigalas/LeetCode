# #433. Minimum Genetic Mutation

<p>A gene string can be represented by an 8-character long string, with choices from <code>'A'</code>, <code>'C'</code>, <code>'G'</code>, and <code>'T'</code>.</p>

<p>Suppose we need to investigate a mutation from a gene string <code>startGene</code> to a gene string <code>endGene</code> where one mutation is defined as one single character changed in the gene string.</p>

<ul>
	<li>For example, <code>"AACCGGTT" --&gt; "AACCGGTA"</code> is one mutation.</li>
</ul>

<p>There is also a gene bank <code>bank</code> that records all the valid gene mutations. A gene must be in <code>bank</code> to make it a valid gene string.</p>

<p>Given the two gene strings <code>startGene</code> and <code>endGene</code> and the gene bank <code>bank</code>, return <em>the minimum number of mutations needed to mutate from </em><code>startGene</code><em> to </em><code>endGene</code>. If there is no such a mutation, return <code>-1</code>.</p>

<p>Note that the starting point is assumed to be valid, so it might not be included in the bank.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= bank.length &lt;= 10</code></li>
	<li><code>startGene.length == endGene.length == bank[i].length == 8</code></li>
	<li><code>startGene</code>, <code>endGene</code>, and <code>bank[i]</code> consist of only the characters <code>['A', 'C', 'G', 'T']</code>.</li>
</ul>

## Notes

Solution, which uses standard approach constructing each possible combination. While constructing new candidate string 
it is doing ```O(n)``` work - overall memory consumption is higher due to a fact that each new candidate is being stored 
in a memory for further analysis. This would become an issue if gene size would be ```n``` 

```go
// Package minimumgeneticmutation contains solution for LeetCode problem: #433. Minimum Genetic Mutation.
package minimumgeneticmutation

import "strings"

// State contains data about current step within BFS.
type State struct {
	gene  string
	steps int
}

// minMutation given the two gene strings startGene and endGene and the gene bank bank, returns the
// minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
func minMutation(startGene string, endGene string, bank []string) int {
	if len(bank) == 0 {
		return -1
	}

	whitelist := make(map[string]struct{}, len(bank))
	for _, val := range bank {
		whitelist[val] = struct{}{}
	}

	queue := make([]*State, 1)
	queue[0] = &State{
		gene: startGene,
	}
	seen := make(map[string]struct{})
	seen[startGene] = struct{}{}

	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]
		if state.gene == endGene {
			return state.steps
		}

		for _, char := range []rune{'A', 'C', 'G', 'T'} {
			for i := 0; i < len(state.gene); i++ {
				var sb strings.Builder
				sb.WriteString(state.gene[0:i])
				sb.WriteRune(char)
				sb.WriteString(state.gene[i+1:])
				newGene := sb.String()

				if _, exists := seen[newGene]; exists {
					continue
				}
				seen[newGene] = struct{}{}

				if _, exists := whitelist[newGene]; exists {
					queue = append(queue, &State{
						gene:  newGene,
						steps: state.steps + 1,
					})
				}
			}
		}
	}
	return -1
}
```