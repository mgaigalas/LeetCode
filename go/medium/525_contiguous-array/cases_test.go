package contiguousarray

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [0,1]",
		args: args{
			nums: []int{0, 1},
		},
		want: 2,
	},
	{
		name: "case: [0,1,0]",
		args: args{
			nums: []int{0, 1, 0},
		},
		want: 2,
	},
}
