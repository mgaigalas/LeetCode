package climbingstairs

type args struct {
	n int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: n = 2",
		args: args{
			n: 2,
		},
		want: 2,
	},
	{
		name: "case: n = 3",
		args: args{
			n: 3,
		},
		want: 3,
	},
}
