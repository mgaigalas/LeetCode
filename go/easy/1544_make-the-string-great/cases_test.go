package makethestringgreat

type args struct {
	s string
}

var testCases = []struct {
	name string
	args args
	want string
}{
	{
		name: "case: s = \"leEeetcode\"",
		args: args{
			s: "leEeetcode",
		},
		want: "leetcode",
	},
	{
		name: "case: s = \"abBAcC\"",
		args: args{
			s: "abBAcC",
		},
		want: "",
	},
	{
		name: "case: s = \"s\"",
		args: args{
			s: "s",
		},
		want: "s",
	},
	{
		name: "case: s = \"Pp\"",
		args: args{
			s: "Pp",
		},
		want: "",
	},
}
