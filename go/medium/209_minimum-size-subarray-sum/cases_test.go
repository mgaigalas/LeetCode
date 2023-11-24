package minsizesubarraysum

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
		name: "case: [2,3,1,2,4,3]",
		args: args{
			nums:   []int{2, 3, 1, 2, 4, 3},
			target: 7,
		},
		want: 2,
	},
	{
		name: "case: [1,4,4]",
		args: args{
			nums:   []int{1, 4, 4},
			target: 4,
		},
		want: 1,
	},
	{
		name: "case: [1,1,1,1,1,1,1,1]",
		args: args{
			nums:   []int{1, 1, 1, 1, 1, 1, 1, 1},
			target: 11,
		},
		want: 0,
	},
}
