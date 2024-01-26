package kthlargestelementinarray

type args struct {
	nums []int
	k    int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: nums = [3,2,1,5,6,4], k = 2",
		args: args{
			nums: []int{3, 2, 1, 5, 6, 4},
			k:    2,
		},
		want: 5,
	},
	{
		name: "case: nums = [3,2,3,1,2,4,5,5,6], k = 4",
		args: args{
			nums: []int{3, 2, 3, 1, 2, 4, 5, 5, 6},
			k:    4,
		},
		want: 4,
	},
}
