package minimumfallingpathsum

type args struct {
	matrix [][]int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: matrix = [[2,1,3],[6,5,4],[7,8,9]]",
		args: args{
			matrix: [][]int{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}},
		},
		want: 13,
	},
	{
		name: "case: matrix = [[-19,57],[-40,-5]]",
		args: args{
			matrix: [][]int{{-19, 57}, {-40, -5}},
		},
		want: -59,
	},
	{
		name: "case: matrix = [[-80,-13,22],[83,94,-5],[73,-48,61]]",
		args: args{
			matrix: [][]int{{-80, -13, 22}, {83, 94, -5}, {73, -48, 61}},
		},
		want: -66,
	},
}
