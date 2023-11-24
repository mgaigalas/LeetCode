package sqrsortarray

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [-4,-1,0,3,10]",
		args: args{
			nums: []int{-4, -1, 0, 3, 10},
		},
		want: []int{0, 1, 9, 16, 100},
	},
	{
		name: "case: [-7,-3,2,3,11]",
		args: args{
			nums: []int{-7, -3, 2, 3, 11},
		},
		want: []int{4, 9, 9, 49, 121},
	},
}
