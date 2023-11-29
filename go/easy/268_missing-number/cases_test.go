package missingnumber

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [3,0,1]",
		args: args{
			nums: []int{3, 0, 1},
		},
		want: 2,
	},
	{
		name: "case: [0,1]",
		args: args{
			nums: []int{0, 1},
		},
		want: 2,
	},
	{
		name: "case: [9,6,4,2,3,5,7,0,1]",
		args: args{
			nums: []int{9, 6, 4, 2, 3, 5, 7, 0, 1},
		},
		want: 8,
	},
}
