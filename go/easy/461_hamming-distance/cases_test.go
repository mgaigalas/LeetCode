package hammingdistance

type args struct {
	x, y int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: x = 1, y = 4",
		args: args{
			x: 1, y: 4,
		},
		want: 2,
	},
	{
		name: "case: x = 3, y = 1",
		args: args{
			x: 3, y: 1,
		},
		want: 1,
	},
}
