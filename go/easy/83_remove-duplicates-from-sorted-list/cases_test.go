package remduplfromsortlist

type args struct {
	head []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [1,1,2]",
		args: args{
			head: []int{1, 1, 2},
		},
		want: []int{1, 2},
	},
	{
		name: "case: [1,1,2,3,3]",
		args: args{
			head: []int{1, 1, 2, 3, 3},
		},
		want: []int{1, 2, 3},
	},
	{
		name: "case: [1,1,1]",
		args: args{
			head: []int{1, 1, 1},
		},
		want: []int{1},
	},
	{
		name: "case: [1,1,1,2]",
		args: args{
			head: []int{1, 1, 1, 2},
		},
		want: []int{1, 2},
	},
	{
		name: "case: [1,1,1,1]",
		args: args{
			head: []int{1, 1, 1, 1},
		},
		want: []int{1},
	},
}
