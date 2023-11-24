package maxsubarrayone

type args struct {
	nums []int
	k    int
}

var testCases = []struct {
	name string
	args args
	want float64
}{
	{
		name: "case: [1,12,-5,-6,50,3]",
		args: args{
			nums: []int{1, 12, -5, -6, 50, 3},
			k:    4,
		},
		want: 12.75000,
	},
	{
		name: "case: [5]",
		args: args{
			nums: []int{5},
			k:    1,
		},
		want: 5.00000,
	},
}
