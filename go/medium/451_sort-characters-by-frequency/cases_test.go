package sortcharsbyfreq

type args struct {
	s string
}

var testCases = []struct {
	name string
	args args
	want []string
}{
	{
		name: "case: s = \"tree\"",
		args: args{
			s: "tree",
		},
		want: []string{"eert", "eetr"},
	},
	{
		name: "case: s = \"cccaaa\"",
		args: args{
			s: "cccaaa",
		},
		want: []string{"aaaccc", "cccaaa"},
	},
	{
		name: "case: s = \"Aabb\"",
		args: args{
			s: "Aabb",
		},
		want: []string{"bbaA", "bbAa"},
	},
}
