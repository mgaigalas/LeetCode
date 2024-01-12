package insertintoabinarysearchtree

import "math"

type args struct {
	root []int
	val  int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: root = [4,2,7,1,3], val = 5",
		args: args{
			root: []int{4, 2, 7, 1, 3},
			val:  5,
		},
		want: []int{4, 2, 7, 1, 3, 5},
	},
	{
		name: "case: root = [40,20,60,10,30,50,70], val = 25",
		args: args{
			root: []int{40, 20, 60, 10, 30, 50, 70},
			val:  25,
		},
		want: []int{40, 20, 60, 10, 30, 50, 70, math.MinInt64, math.MinInt64, 25},
	},
	{
		name: "case: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5",
		args: args{
			root: []int{4, 2, 7, 1, 3, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64},
			val:  5,
		},
		want: []int{4, 2, 7, 1, 3, 5},
	},
	{
		name: "case: root = [55,28,92,26,43,null,null,null,null,null,null], val = 1",
		args: args{
			root: []int{55, 28, 92, 26, 43, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64, math.MinInt64},
			val:  1,
		},
		want: []int{55, 28, 92, 26, 43, math.MinInt64, math.MinInt64, 1},
	},
	{
		name: "case: root = [8,null,55,39,null,11,null,null,23,null,null], val = 17",
		args: args{
			root: []int{8, math.MinInt64, 55, 39, math.MinInt64, 11, math.MinInt64, math.MinInt64, 23, math.MinInt64, math.MinInt64},
			val:  17,
		},
		want: []int{8, math.MinInt64, 55, 39, math.MinInt64, 11, math.MinInt64, math.MinInt64, 23, 17},
	},
	{
		name: "case: root = [], val = 5",
		args: args{
			root: []int{},
			val:  5,
		},
		want: []int{5},
	},
}
