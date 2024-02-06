package permutations

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
		want: [][]int{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}},
	},
	{
		name: "case: nums = [0,1]",
		args: args{
			nums: []int{0, 1},
		},
		want: [][]int{{0, 1}, {1, 0}},
	},
	{
		name: "case: nums = [1]",
		args: args{
			nums: []int{1},
		},
		want: [][]int{{1}},
	},
}
