package deepestleavessum

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
		name: "case: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]",
		args: args{
			root: []int{1, 2, 3, 4, 5, math.MinInt64, 6, 7, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64, 8},
		},
		want: 15,
	},
	{
		name: "case: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]",
		args: args{
			root: []int{6, 7, 8, 2, 7, 1, 3, 9, math.MinInt64, 1, 4, math.MinInt64, math.MinInt64, math.MinInt64, 5},
		},
		want: 19,
	},
}
