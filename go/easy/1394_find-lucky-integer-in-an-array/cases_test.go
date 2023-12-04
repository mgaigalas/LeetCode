package findluckyintegerinanarray

type args struct {
	arr []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [2,2,3,4]",
		args: args{
			arr: []int{2, 2, 3, 4},
		},
		want: 2,
	},
	{
		name: "case: [1,2,2,3,3,3]",
		args: args{
			arr: []int{1, 2, 2, 3, 3, 3},
		},
		want: 3,
	},
	{
		name: "case: [2,2,2,3,3]",
		args: args{
			arr: []int{2, 2, 2, 3, 3},
		},
		want: -1,
	},
}
