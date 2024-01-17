package reachablenodeswithrestrictions

type args struct {
	n          int
	edges      [][]int
	restricted []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]",
		args: args{
			n:          7,
			edges:      [][]int{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}},
			restricted: []int{4, 5},
		},
		want: 4,
	},
	{
		name: "case: n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]",
		args: args{
			n:          7,
			edges:      [][]int{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}},
			restricted: []int{4, 2, 1},
		},
		want: 3,
	},
}
