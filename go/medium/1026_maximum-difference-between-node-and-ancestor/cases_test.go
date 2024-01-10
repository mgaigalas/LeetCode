package maxdiffbetweennodeandancestor

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
		name: "case: root = [8,3,10,1,6,null,14,null,null,4,7,13]",
		args: args{
			root: []int{8, 3, 10, 1, 6, math.MinInt64, 14, math.MinInt64, math.MinInt64, 4, 7, 13},
		},
		want: 7,
	},
	{
		name: "case: root = [1,null,2,null,0,3]",
		args: args{
			root: []int{1, math.MinInt64, 2, math.MinInt64, 0, 3},
		},
		want: 3,
	},
}
