package validpalindrome

type args struct {
	s string
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: s = \"A man, a plan, a canal: Panama\"",
		args: args{
			s: "A man, a plan, a canal: Panama",
		},
		want: true,
	},
	{
		name: "case: s = \"race a car\"",
		args: args{
			s: "race a car",
		},
		want: false,
	},
	{
		name: "case: s = \" \"",
		args: args{
			s: " ",
		},
		want: true,
	},
}
