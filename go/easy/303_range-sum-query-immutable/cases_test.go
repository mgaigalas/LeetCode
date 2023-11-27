package rangesumqueryimtbl

type args struct {
	nums []int
	args [][]int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [-2,0,3,-5,2,-1]",
		args: args{
			nums: []int{-2, 0, 3, -5, 2, -1},
			args: [][]int{{0, 2}, {2, 5}, {0, 5}},
		},
		want: []int{1, -1, -3},
	},
}
