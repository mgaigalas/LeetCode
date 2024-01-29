package maximumsixtyninenumber

type args struct {
	num int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: num = 9669",
		args: args{
			num: 9669,
		},
		want: 9969,
	},
	{
		name: "case: num = 9996",
		args: args{
			num: 9996,
		},
		want: 9999,
	},
	{
		name: "case: num = 9999",
		args: args{
			num: 9999,
		},
		want: 9999,
	},
}
