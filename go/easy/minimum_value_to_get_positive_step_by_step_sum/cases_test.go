package minvalforgetposstpbystpsum

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [-3,2,-3,4,2]",
		args: args{
			nums: []int{-3, 2, -3, 4, 2},
		},
		want: 5,
	},
	{
		name: "case: [1,2]",
		args: args{
			nums: []int{1, 2},
		},
		want: 1,
	},
	{
		name: "case: [1,-2,-3]",
		args: args{
			nums: []int{1, -2, -3},
		},
		want: 5,
	},
	{
		name: "case: [-3,6,2,5,8,6]",
		args: args{
			nums: []int{-3, 6, 2, 5, 8, 6},
		},
		want: 4,
	},
	{
		name: "case: [2,3,5,-5,-1]",
		args: args{
			nums: []int{2, 3, 5, -5, -1},
		},
		want: 1,
	},
}
