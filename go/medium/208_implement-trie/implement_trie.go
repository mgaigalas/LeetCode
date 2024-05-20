// Package implementtrie contains solution for LeetCode problem: #208. Implement Trie (Prefix Tree).
package implementtrie

// Trie is a structure representing a node of Trie data structure.
type Trie struct {
	nodes [26]*Trie
	isEnd bool
}

// Constructor creates and returns new instance of Trie.
func Constructor() Trie {
	return Trie{}
}

// Insert creates sub-nodes (one per word letter) for root Trie node.
func (this *Trie) Insert(word string) {
	curr := this
	for i := 0; i < len(word); i++ {
		idx := word[i] - 'a'
		if curr.nodes[idx] == nil {
			curr.nodes[idx] = &Trie{}
		}
		curr = curr.nodes[idx]
	}
	curr.isEnd = true
}

// Search checks if Trie nodes has connected nodes containing one per each letter in word.
// Last letter node must be end of Trie.
func (this *Trie) Search(word string) bool {
	curr := this
	for i := 0; i < len(word); i++ {
		idx := word[i] - 'a'
		if curr.nodes[idx] == nil {
			return false
		}
		curr = curr.nodes[idx]
	}
	return curr.isEnd
}

// StartsWith checks if Trie nodes has connected nodes containing one per each letter in word.
func (this *Trie) StartsWith(prefix string) bool {
	curr := this
	for i := 0; i < len(prefix); i++ {
		idx := prefix[i] - 'a'
		if curr.nodes[idx] == nil {
			return false
		}
		curr = curr.nodes[idx]
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
