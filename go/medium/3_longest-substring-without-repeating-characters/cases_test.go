package longestsubstrworepeatingchars

type args struct {
	s string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: s = \"abcabcbb\"",
		args: args{
			s: "abcabcbb",
		},
		want: 3,
	},
	{
		name: "case: s = \"bbbbb\"",
		args: args{
			s: "bbbbb",
		},
		want: 1,
	},
	{
		name: "case: s = \"pwwkew\"",
		args: args{
			s: "pwwkew",
		},
		want: 3,
	},
	{
		name: "case: s = \"dvdf\"",
		args: args{
			s: "dvdf",
		},
		want: 3,
	},
}
