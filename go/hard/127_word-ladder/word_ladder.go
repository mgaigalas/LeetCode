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
	// build graphs, where source nodes are post-processed words from a list with placeholders for letter replacement
	// mapped to actual words from word list
	graphs := make(map[string][]string, len(wordList))
	for _, word := range wordList {
		for i := 0; i < len(word); i++ {
			var sb strings.Builder
			sb.WriteString(word[0:i])
			sb.WriteRune('*')
			sb.WriteString(word[i+1:])
			newWord := sb.String()

			if nodes, exists := graphs[newWord]; exists {
				nodes = append(nodes, word)
				graphs[newWord] = nodes
				continue
			}
			nodes := make([]string, 1, len(word))
			nodes[0] = word
			graphs[newWord] = nodes
		}
	}

	queue := make([]*State, 1, len(wordList))
	queue[0] = &State{
		word:  beginWord,
		turns: 1,
	}
	seen := make(map[string]struct{}, len(wordList))
	seen[beginWord] = struct{}{}

	for len(queue) > 0 {
		state := queue[0]
		queue = queue[1:]
		sourceWord := state.word

		for i := 0; i < len(sourceWord); i++ {
			// create a keys (source nodes) for querying graphs
			var sb strings.Builder
			sb.WriteString(sourceWord[0:i])
			sb.WriteRune('*')
			sb.WriteString(sourceWord[i+1:])
			newWord := sb.String()

			// go through all connected nodes as actual values (destination nodes) from word list
			for _, word := range graphs[newWord] {
				// if destination is same as required target - return result without actually processing it, thus +1
				if word == endWord {
					return state.turns + 1
				}

				if _, exists := seen[word]; exists {
					continue
				}
				seen[word] = struct{}{}
				queue = append(queue, &State{
					word:  word,
					turns: state.turns + 1,
				})
			}
		}
	}
	return 0
}
