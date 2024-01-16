package numofconnectedcomponentsinundirectedgraph

type args struct {
	n     int
	edges [][]int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: n = 5, edges = [[0,1],[1,2],[3,4]]",
		args: args{
			n:     5,
			edges: [][]int{{0, 1}, {1, 2}, {3, 4}},
		},
		want: 2,
	},
	{
		name: "case: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]",
		args: args{
			n:     5,
			edges: [][]int{{0, 1}, {1, 2}, {2, 3}, {3, 4}},
		},
		want: 1,
	},
	{
		name: "case: n = 5, edges = [[0,1],[0,2],[2,3],[2,4]]",
		args: args{
			n:     5,
			edges: [][]int{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
		},
		want: 1,
	},
}
