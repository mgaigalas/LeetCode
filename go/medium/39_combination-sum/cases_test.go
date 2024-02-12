package combinationsum

type args struct {
	candidates []int
	target     int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: candidates = [2,3,6,7], target = 7",
		args: args{
			candidates: []int{2, 3, 6, 7},
			target:     7,
		},
		want: [][]int{{2, 2, 3}, {7}},
	},
	{
		name: "case: candidates = [2,3,5], target = 8",
		args: args{
			candidates: []int{2, 3, 5},
			target:     8,
		},
		want: [][]int{{2, 2, 2, 2}, {2, 3, 3}, {3, 5}},
	},
	{
		name: "case: candidates = [2], target = 1",
		args: args{
			candidates: []int{2},
			target:     1,
		},
		want: [][]int{},
	},
}
