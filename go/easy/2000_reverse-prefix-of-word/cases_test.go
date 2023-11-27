package reverseprefixofword

type args struct {
	word string
	ch   byte
}

var testCases = []struct {
	name string
	args args
	want string
}{
	{
		name: "case: \"abcdefd\"",
		args: args{
			word: "abcdefd",
			ch:   byte('d'),
		},
		want: "dcbaefd",
	},
	{
		name: "case: \"xyxzxe\"",
		args: args{
			word: "xyxzxe",
			ch:   byte('z'),
		},
		want: "zxyxxe",
	},
	{
		name: "case: \"abcd\"",
		args: args{
			word: "abcd",
			ch:   byte('z'),
		},
		want: "abcd",
	},
}
