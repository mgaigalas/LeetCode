package kclosestpointstoorigin

type args struct {
	points [][]int
	k      int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: points = [[1,3],[-2,2]], k = 1",
		args: args{
			points: [][]int{{1, 3}, {-2, 2}},
			k:      1,
		},
		want: [][]int{{-2, 2}},
	},
	{
		name: "case: points = [[3,3],[5,-1],[-2,4]], k = 2",
		args: args{
			points: [][]int{{3, 3}, {5, -1}, {-2, 4}},
			k:      2,
		},
		want: [][]int{{-2, 4}, {3, 3}},
	},
}
