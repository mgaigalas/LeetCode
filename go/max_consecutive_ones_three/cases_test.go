package maxconseconesthree

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
		name: "case: [1,1,1,0,0,0,1,1,1,1,0]",
		args: args{
			nums: []int{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
			k:    2,
		},
		want: 6,
	},
	{
		name: "case: [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]",
		args: args{
			nums: []int{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
			k:    3,
		},
		want: 10,
	},
}
