package uniquenumberofoccurrences

type args struct {
	arr []int
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: [1,2,2,1,1,3]",
		args: args{
			arr: []int{1, 2, 2, 1, 1, 3},
		},
		want: true,
	},
	{
		name: "case: [1,2]",
		args: args{
			arr: []int{1, 2},
		},
		want: false,
	},
	{
		name: "case: [-3,0,1,-3,1,1,1,-3,10,0]",
		args: args{
			arr: []int{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0},
		},
		want: true,
	},
	{
		name: "case: [-1,-1,-1,-3,-1,-1]",
		args: args{
			arr: []int{-1, -1, -1, -3, -1, -1},
		},
		want: true,
	},
}
