package searchinsertposition

type args struct {
	nums   []int
	target int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: nums = [1,3,5,6], target = 5",
		args: args{
			nums:   []int{1, 3, 5, 6},
			target: 5,
		},
		want: 2,
	},
	{
		name: "case: nums = [1,3,5,6], target = 2",
		args: args{
			nums:   []int{1, 3, 5, 6},
			target: 2,
		},
		want: 1,
	},
	{
		name: "case: nums = [1,3,5,6], target = 7",
		args: args{
			nums:   []int{1, 3, 5, 6},
			target: 7,
		},
		want: 4,
	},
	{
		name: "case: nums = [-1, 3, 5, 6], target = -10",
		args: args{
			nums:   []int{-1, 3, 5, 6},
			target: -10,
		},
		want: 0,
	},
}
