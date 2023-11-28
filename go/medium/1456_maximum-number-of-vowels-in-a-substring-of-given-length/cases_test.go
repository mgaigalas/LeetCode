package maxnumofvowelsinsubstrofgivenlength

type args struct {
	s string
	k int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: \"abciiidef\"",
		args: args{
			s: "abciiidef",
			k: 3,
		},
		want: 3,
	},
	{
		name: "case: \"aeiou\"",
		args: args{
			s: "aeiou",
			k: 2,
		},
		want: 2,
	},
	{
		name: "case: \"leetcode\"",
		args: args{
			s: "leetcode",
			k: 3,
		},
		want: 2,
	},
}
