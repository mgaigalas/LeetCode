package sumofuniqueelements

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [1,2,3,2]",
		args: args{
			nums: []int{1, 2, 3, 2},
		},
		want: 4,
	},
	{
		name: "case: [1,1,1,1,1]",
		args: args{
			nums: []int{1, 1, 1, 1, 1},
		},
		want: 0,
	},
	{
		name: "case: [1,2,3,4,5]",
		args: args{
			nums: []int{1, 2, 3, 4, 5},
		},
		want: 15,
	},
}
