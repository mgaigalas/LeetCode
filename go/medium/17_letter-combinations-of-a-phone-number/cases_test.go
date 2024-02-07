package lettercombinationsofphonenumber

type args struct {
	digits string
}

var testCases = []struct {
	name string
	args args
	want []string
}{
	{
		name: "case: digits = \"23\"",
		args: args{
			digits: "23",
		},
		want: []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
	},
	{
		name: "case: digits = \"\"",
		args: args{
			digits: "",
		},
		want: []string{},
	},
	{
		name: "case: digits = \"2\"",
		args: args{
			digits: "2",
		},
		want: []string{"a", "b", "c"},
	},
}
