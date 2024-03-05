package snakesandladders

type args struct {
	board [][]int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1]," +
			"[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]",
		args: args{
			board: [][]int{
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 35, -1, -1, 13, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 15, -1, -1, -1, -1}},
		},
		want: 4,
	},
	{
		name: "case: board = [[-1,-1],[-1,3]]",
		args: args{
			board: [][]int{
				{-1, -1},
				{-1, 3}},
		},
		want: 1,
	},
}
