package uniquepathstwo

type args struct {
	obstacleGrid [][]int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]",
		args: args{
			obstacleGrid: [][]int{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
		},
		want: 2,
	},
	{
		name: "case: obstacleGrid = [[0,1],[0,0]]",
		args: args{
			obstacleGrid: [][]int{{0, 1}, {0, 0}},
		},
		want: 1,
	},
	{
		name: "case: obstacleGrid = [[1]]",
		args: args{
			obstacleGrid: [][]int{{1}},
		},
		want: 0,
	},
}
