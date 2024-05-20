package implementtrie

import (
	"testing"
)

func TestTrieAll(t *testing.T) {
	for _, tt := range testCases {
		this := Constructor()
		t.Run(tt.name, func(t *testing.T) {
			for idx, op := range tt.args.operations {
				switch op {
				case insertOp:
					this.Insert(tt.args.input[idx])
				case searchOp:
					assert(this.Search(tt.args.input[idx]), tt.want[idx], "Search()", t)
				case startsWithOp:
					assert(this.StartsWith(tt.args.input[idx]), tt.want[idx], "StartsWith()", t)
				default:
					panic("invalid operation")
				}
			}
		})
	}
}

func assert(got bool, r res, fName string, t *testing.T) {
	want := toBool(r)
	if got == want {
		return
	}
	t.Errorf("%s = %v, want %v", fName, got, want)
}

func toBool(r res) bool {
	switch r {
	case trueRes:
		return true
	default:
		return false
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.insertOp(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
