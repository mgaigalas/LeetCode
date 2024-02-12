package combinationsumthree

type args struct {
	k int
	n int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: k = 3, n = 7",
		args: args{
			k: 3,
			n: 7,
		},
		want: [][]int{{1, 2, 4}},
	},
	{
		name: "case: k = 3, n = 9",
		args: args{
			k: 3,
			n: 9,
		},
		want: [][]int{{1, 2, 6}, {1, 3, 5}, {2, 3, 4}},
	},
	{
		name: "case: k = 4, n = 1",
		args: args{
			k: 4,
			n: 1,
		},
		want: [][]int{},
	},
	{
		name: "case: k = 2, n = 18",
		args: args{
			k: 2,
			n: 18,
		},
		want: [][]int{},
	},
	{
		name: "case: k = 9, n = 45",
		args: args{
			k: 9,
			n: 45,
		},
		want: [][]int{{1, 2, 3, 4, 5, 6, 7, 8, 9}},
	},
}
