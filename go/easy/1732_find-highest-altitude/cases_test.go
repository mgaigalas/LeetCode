package findhighestalt

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: [-5,1,5,0,-7]",
		args: args{
			nums: []int{-5, 1, 5, 0, -7},
		},
		want: 1,
	},
	{
		name: "case: [-4,-3,-2,-1,4,3,2]",
		args: args{
			nums: []int{-4, -3, -2, -1, 4, 3, 2},
		},
		want: 0,
	},
}
