package findifpathexistsingraph

type args struct {
	n           int
	source      int
	destination int
	edges       [][]int
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2",
		args: args{
			n:           3,
			source:      0,
			destination: 2,
			edges:       [][]int{{0, 1}, {1, 2}, {2, 0}},
		},
		want: true,
	},
	{
		name: "case: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5",
		args: args{
			n:           6,
			source:      0,
			destination: 5,
			edges:       [][]int{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}},
		},
		want: false,
	},
	{
		name: "case: n = 10, edges = [[2,9],[7,8],[5,9],[7,2],[3,8],[2,8],[1,6],[3,0],[7,0],[8,5]], source = 1, destination = 0",
		args: args{
			n:           10,
			source:      1,
			destination: 0,
			edges:       [][]int{{2, 9}, {7, 8}, {5, 9}, {7, 2}, {3, 8}, {2, 8}, {1, 6}, {3, 0}, {7, 0}, {8, 5}},
		},
		want: false,
	},
	{
		name: "case: n = 10, edges = [[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]], source = 5, destination = 9",
		args: args{
			n:           10,
			source:      5,
			destination: 9,
			edges:       [][]int{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}},
		},
		want: true,
	},
}
