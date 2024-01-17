package nearestexitfromentranceinmaze

type args struct {
	maze     [][]byte
	entrance []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: maze = [[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]], " +
			"entrance = [1,2]",
		args: args{
			maze:     [][]byte{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}},
			entrance: []int{1, 2},
		},
		want: 1,
	},
	{
		name: "case: maze = [[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]], entrance = [1,0]",
		args: args{
			maze:     [][]byte{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}},
			entrance: []int{1, 0},
		},
		want: 2,
	},
	{
		name: "case: maze = [[\".\",\"+\"]], entrance = [0,0]",
		args: args{
			maze:     [][]byte{{'.', '+'}},
			entrance: []int{0, 0},
		},
		want: -1,
	},
	{
		name: "case: maze = [[\".\",\".\"]], entrance = [0,1]",
		args: args{
			maze:     [][]byte{{'.', '.'}},
			entrance: []int{0, 1},
		},
		want: 1,
	},
}
