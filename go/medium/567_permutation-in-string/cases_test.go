package permutationinstring

type args struct {
	s1 string
	s2 string
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: s1 = \"ab\", s2 = \"eidbaooo\"",
		args: args{
			s1: "ab",
			s2: "eidbaooo",
		},
		want: true,
	},
	{
		name: "case: s1 = \"ab\", s2 = \"eidboaoo\"",
		args: args{
			s1: "ab",
			s2: "eidboaoo",
		},
		want: false,
	},
	{
		name: "case: s1 = \"a\", s2 = \"ab\"",
		args: args{
			s1: "a",
			s2: "ab",
		},
		want: true,
	},
	{
		name: "case: s1 = \"adc\", s2 = \"dcda\"",
		args: args{
			s1: "adc",
			s2: "dcda",
		},
		want: true,
	},
	{
		name: "case: s1 = \"hello\", s2 = \"ooolleoooleh\"",
		args: args{
			s1: "hello",
			s2: "ooolleoooleh",
		},
		want: false,
	},
	{
		name: "case: s1 = \"ab\", s2 = \"a\"",
		args: args{
			s1: "ab",
			s2: "a",
		},
		want: false,
	},
}
