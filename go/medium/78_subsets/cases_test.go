package subsets

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want [][]int
}{
	{
		name: "case: nums = [1,2,3]",
		args: args{
			nums: []int{1, 2, 3},
		},
		want: [][]int{{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}},
	},
	{
		name: "case: nums = [0]",
		args: args{
			nums: []int{0},
		},
		want: [][]int{{}, {0}},
	},
}
