package longestcommonsubsequence

type args struct {
	text1 string
	text2 string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: text1 = \"abcde\", text2 = \"ace\"",
		args: args{
			text1: "abcde",
			text2: "ace",
		},
		want: 3,
	},
	{
		name: "case: text1 = \"abc\", text2 = \"abc\"",
		args: args{
			text1: "abc",
			text2: "abc",
		},
		want: 3,
	},
	{
		name: "case: text1 = \"abc\", text2 = \"def\"",
		args: args{
			text1: "abc",
			text2: "def",
		},
		want: 0,
	},
}
