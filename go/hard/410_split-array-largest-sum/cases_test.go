package splitarraylargestsum

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
		name: "case: nums = [7,2,5,10,8], k = 2",
		args: args{
			nums: []int{7, 2, 5, 10, 8},
			k:    2,
		},
		want: 18,
	},
	{
		name: "case: nums = [1,2,3,4,5], k = 2",
		args: args{
			nums: []int{1, 2, 3, 4, 5},
			k:    2,
		},
		want: 9,
	},
}
