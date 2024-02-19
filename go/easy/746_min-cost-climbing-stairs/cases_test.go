package mincostclimbingstairs

type args struct {
	cost []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: cost = [10,15,20]",
		args: args{
			cost: []int{10, 15, 20},
		},
		want: 15,
	},
	{
		name: "case: cost = [1,100,1,1,1,100,1,1,100,1]",
		args: args{
			cost: []int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
		},
		want: 6,
	},
}
