package findplayerswithzerooronelosses

type args struct {
	matches [][]int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]",
		args: args{
			matches: [][]int{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}},
		},
		want: [][]int{{1, 2, 10}, {4, 5, 7, 8}},
	},
	{
		name: "case: [[2,3],[1,3],[5,4],[6,4]]",
		args: args{
			matches: [][]int{{2, 3}, {1, 3}, {5, 4}, {6, 4}},
		},
		want: [][]int{{1, 2, 5, 6}, {}},
	},
}
