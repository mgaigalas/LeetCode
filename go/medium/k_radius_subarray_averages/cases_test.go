package kradiussubarrayavgs

type args struct {
	nums []int
	k    int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [7,4,3,9,1,8,5,2,6]",
		args: args{
			nums: []int{7, 4, 3, 9, 1, 8, 5, 2, 6},
			k:    3,
		},
		want: []int{-1, -1, -1, 5, 4, 4, -1, -1, -1},
	},
	{
		name: "case: [100000]",
		args: args{
			nums: []int{100000},
			k:    0,
		},
		want: []int{100000},
	},
	{
		name: "case: [8]",
		args: args{
			nums: []int{8},
			k:    100000,
		},
		want: []int{-1},
	},
}
