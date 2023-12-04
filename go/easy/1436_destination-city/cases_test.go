package destinationcity

type args struct {
	paths [][]string
}

var testCases = []struct {
	name string
	args args
	want string
}{
	{
		name: "case: paths = [[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]",
		args: args{
			paths: [][]string{{"London", "New York"}, {"New York", "Lima"}, {"Lima", "Sao Paulo"}},
		},
		want: "Sao Paulo",
	},
	{
		name: "case: paths = [[\"B\",\"C\"],[\"D\",\"B\"],[\"C\",\"A\"]]",
		args: args{
			paths: [][]string{{"B", "C"}, {"D", "B"}, {"C", "A"}},
		},
		want: "A",
	},
	{
		name: "case: paths = [[\"A\",\"Z\"]]",
		args: args{
			paths: [][]string{{"A", "Z"}},
		},
		want: "Z",
	},
}
