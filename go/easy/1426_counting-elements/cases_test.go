package countingelements

type args struct {
	arr []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [1,2,3]",
		args: args{
			arr: []int{1, 2, 3},
		},
		want: 2,
	},
	{
		name: "case: [1,1,3,3,5,5,7,7]",
		args: args{
			arr: []int{1, 1, 3, 3, 5, 5, 7, 7},
		},
		want: 0,
	},
	{
		name: "case: [1,3,2,3,5,0]",
		args: args{
			arr: []int{1, 3, 2, 3, 5, 0},
		},
		want: 3,
	},
}
