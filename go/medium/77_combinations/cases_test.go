package combinations

type args struct {
	n int
	k int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: n = 4, k = 2",
		args: args{
			n: 4,
			k: 2,
		},
		want: [][]int{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}},
	},
	{
		name: "case: n = 1, k = 1",
		args: args{
			n: 1,
			k: 1,
		},
		want: [][]int{{1}},
	},
}
