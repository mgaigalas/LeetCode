package mindepthofbinarytree

import "math"

type args struct {
	root []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: root = [3,9,20,null,null,15,7]",
		args: args{
			root: []int{3, 9, 20, math.MinInt64, math.MinInt64, 15, 7},
		},
		want: 2,
	},
	{
		name: "case: root = [2,null,3,null,4,null,5,null,6]",
		args: args{
			root: []int{2, math.MinInt64, 3, math.MinInt64, 4, math.MinInt64, 5, math.MinInt64, 6},
		},
		want: 5,
	},
}
