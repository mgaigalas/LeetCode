package ransomnote

type args struct {
	ransomNote string
	magazine   string
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: ransomNote = \"a\", magazine = \"b\"",
		args: args{
			ransomNote: "a",
			magazine:   "b",
		},
		want: false,
	},
	{
		name: "case: ransomNote = \"aa\", magazine = \"ab\"",
		args: args{
			ransomNote: "aa",
			magazine:   "ab",
		},
		want: false,
	},
	{
		name: "case: ransomNote = \"aa\", magazine = \"aab\"",
		args: args{
			ransomNote: "aa",
			magazine:   "aab",
		},
		want: true,
	},
}
