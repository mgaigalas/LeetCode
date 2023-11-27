package reverseonlyletters

type args struct {
	s string
}

var testCases = []struct {
	name string
	args args
	want string
}{
	{
		name: "case: \"ab-cd\"",
		args: args{
			s: "ab-cd",
		},
		want: "dc-ba",
	},
	{
		name: "case: \"a-bC-dEf-ghIj\"",
		args: args{
			s: "a-bC-dEf-ghIj",
		},
		want: "j-Ih-gfE-dCba",
	},
	{
		name: "case: \"Test1ng-Leet=code-Q!\"",
		args: args{
			s: "Test1ng-Leet=code-Q!",
		},
		want: "Qedo1ct-eeLg=ntse-T!",
	},
}
