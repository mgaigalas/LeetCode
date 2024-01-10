package binarytreezigzaglevelordertraversal

import "math"

type args struct {
	root []int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: root = [3,9,20,null,null,15,7]",
		args: args{
			root: []int{3, 9, 20, math.MinInt64, math.MinInt64, 15, 7},
		},
		want: [][]int{{3}, {20, 9}, {15, 7}},
	},
	{
		name: "case: root = [1]",
		args: args{
			root: []int{1},
		},
		want: [][]int{{1}},
	},
	{
		name: "case: root = []",
		args: args{
			root: []int{},
		},
		want: [][]int{},
	},
}
