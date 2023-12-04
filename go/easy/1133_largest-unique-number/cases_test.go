package largestuniquenumber

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [5,7,3,9,4,9,8,3,1]",
		args: args{
			nums: []int{5, 7, 3, 9, 4, 9, 8, 3, 1},
		},
		want: 8,
	},
	{
		name: "case: [9,9,8,8]",
		args: args{
			nums: []int{9, 9, 8, 8},
		},
		want: -1,
	},
}
