package insertinterval

type args struct {
	intervals   [][]int
	newInterval []int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: intervals = [[1,3],[6,9]], newInterval = [2,5]",
		args: args{
			intervals:   [][]int{{1, 3}, {6, 9}},
			newInterval: []int{2, 5},
		},
		want: [][]int{{1, 5}, {6, 9}},
	},
	{
		name: "case: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]",
		args: args{
			intervals:   [][]int{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
			newInterval: []int{4, 8},
		},
		want: [][]int{{1, 2}, {3, 10}, {12, 16}},
	},
}
