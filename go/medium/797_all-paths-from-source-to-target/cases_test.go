package allpathsfromsourcetotarget

type args struct {
	graph [][]int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: graph = [[1,2],[3],[3],[]]",
		args: args{
			graph: [][]int{{1, 2}, {3}, {3}, {}},
		},
		want: [][]int{{0, 1, 3}, {0, 2, 3}},
	},
	{
		name: "case: graph = [[4,3,1],[3,2,4],[3],[4],[]]",
		args: args{
			graph: [][]int{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}},
		},
		want: [][]int{{0, 4}, {0, 3, 4}, {0, 1, 3, 4}, {0, 1, 2, 3, 4}, {0, 1, 4}},
	},
}
