package implementtrie

type ops int

const (
	insertOp ops = iota
	searchOp
	startsWithOp
)

type res int

const (
	falseRes res = -1 + iota
	nilRes
	trueRes
)

type args struct {
	operations []ops
	input      []string
}

var testCases = []struct {
	name string
	args args
	want []res
}{
	{
		name: "case: [\"Trie\",\"insert\",\"search\",\"search\",\"startsWith\",\"insert\",\"search\"]" +
			"\n[[],[\"apple\"],[\"apple\"],[\"app\"],[\"app\"],[\"app\"],[\"app\"]]",
		args: args{
			operations: []ops{insertOp, searchOp, searchOp, startsWithOp, insertOp, searchOp},
			input:      []string{"apple", "apple", "app", "app", "app", "app"},
		},
		want: []res{nilRes, trueRes, falseRes, trueRes, nilRes, trueRes},
	},
}
