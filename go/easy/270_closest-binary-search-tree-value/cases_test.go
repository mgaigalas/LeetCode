package closestbinarysearchtreevalue

import "math"

type args struct {
	root   []int
	target float64
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: root = [4,2,5,1,3], target = 3.714286",
		args: args{
			root:   []int{4, 2, 5, 1, 3},
			target: 3.714286,
		},
		want: 4,
	},
	{
		name: "case: root = [1], target = 4.428571",
		args: args{
			root:   []int{1},
			target: 4.428571,
		},
		want: 1,
	},
	{
		name: "case: root = [2,1,3], target = 0.142857",
		args: args{
			root:   []int{2, 1, 3},
			target: 0.142857,
		},
		want: 1,
	},
	{
		name: "case: root = [1,null,2], target = 3.428571",
		args: args{
			root:   []int{1, math.MinInt64, 2},
			target: 3.428571,
		},
		want: 2,
	},
	{
		name: "case: root = [4,2,5,1,3], target = 3.5",
		args: args{
			root:   []int{4, 2, 5, 1, 3},
			target: 3.5,
		},
		want: 3,
	},
}
