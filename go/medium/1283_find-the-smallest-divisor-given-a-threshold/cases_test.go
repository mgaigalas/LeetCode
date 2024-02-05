package findsmallestdivisorgiventhreshold

type args struct {
	nums      []int
	threshold int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: nums = [1,2,5,9], threshold = 6",
		args: args{
			nums:      []int{1, 2, 5, 9},
			threshold: 6,
		},
		want: 5,
	},
	{
		name: "case: nums = [44,22,33,11,1], threshold = 5",
		args: args{
			nums:      []int{44, 22, 33, 11, 1},
			threshold: 5,
		},
		want: 44,
	},
}
