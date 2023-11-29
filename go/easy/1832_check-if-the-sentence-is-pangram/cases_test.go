package sentenceispangram

type args struct {
	sentence string
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: \"thequickbrownfoxjumpsoverthelazydog\"",
		args: args{
			sentence: "thequickbrownfoxjumpsoverthelazydog",
		},
		want: true,
	},
	{
		name: "case: \"leetcode\"",
		args: args{
			sentence: "leetcode",
		},
		want: false,
	},
}
