package customsortstring

type args struct {
	order string
	s     string
}

var testCases = []struct {
	name string
	args args
	want []string
}{
	{
		name: "case: order = \"cba\", s = \"abcd\"",
		args: args{
			order: "cba",
			s:     "abcd",
		},
		want: []string{"dcba", "cdba", "cbda", "cbad"},
	},
	{
		name: "case: order = \"cbafg\", s = \"abcd\"",
		args: args{
			order: "cbafg",
			s:     "abcd",
		},
		want: []string{"cbad"},
	},
}
