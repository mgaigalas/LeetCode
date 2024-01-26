package laststoneweight

type args struct {
	stones []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: stones = [2,7,4,1,8,1]",
		args: args{
			stones: []int{2, 7, 4, 1, 8, 1},
		},
		want: 1,
	},
	{
		name: "case: stones = [1]",
		args: args{
			stones: []int{1},
		},
		want: 1,
	},
}
