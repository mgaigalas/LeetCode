package findpivotindex

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [1,7,3,6,5,6]",
		args: args{
			nums: []int{1, 7, 3, 6, 5, 6},
		},
		want: 3,
	},
	{
		name: "case: [1,2,3]",
		args: args{
			nums: []int{1, 2, 3},
		},
		want: -1,
	},
	{
		name: "case: [2,1,-1]",
		args: args{
			nums: []int{2, 1, -1},
		},
		want: 0,
	},
}
