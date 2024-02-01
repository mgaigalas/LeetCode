package longestsubseqwithlimitedsum

type args struct {
	nums    []int
	queries []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: nums = [4,5,2,1], queries = [3,10,21]",
		args: args{
			nums:    []int{4, 5, 2, 1},
			queries: []int{3, 10, 21},
		},
		want: []int{2, 3, 4},
	},
	{
		name: "case: nums = [2,3,4,5], queries = [1]",
		args: args{
			nums:    []int{2, 3, 4, 5},
			queries: []int{1},
		},
		want: []int{0},
	},
}
