package runningsumonedarray

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [1,2,3,4]",
		args: args{
			nums: []int{1, 2, 3, 4},
		},
		want: []int{1, 3, 6, 10},
	},
	{
		name: "case: [1,1,1,1,1]",
		args: args{
			nums: []int{1, 1, 1, 1, 1},
		},
		want: []int{1, 2, 3, 4, 5},
	},
	{
		name: "case: [3,1,2,10,1]",
		args: args{
			nums: []int{3, 1, 2, 10, 1},
		},
		want: []int{3, 4, 6, 16, 17},
	},
}
