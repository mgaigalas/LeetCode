package movezeroes

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [0,1,0,3,12]",
		args: args{
			nums: []int{0, 1, 0, 3, 12},
		},
		want: []int{1, 3, 12, 0, 0},
	},
	{
		name: "case: [0]",
		args: args{
			nums: []int{0},
		},
		want: []int{0},
	},
	{
		name: "case: [1,0,1]",
		args: args{
			nums: []int{1, 0, 1},
		},
		want: []int{1, 1, 0},
	},
}
