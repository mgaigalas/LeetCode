package generateparentheses

type args struct {
	n int
}

var testCases = []struct {
	name string
	args args
	want []string
}{
	{
		name: "case: n = 3",
		args: args{
			n: 3,
		},
		want: []string{"((()))", "(()())", "(())()", "()(())", "()()()"},
	},
	{
		name: "case: n = 1",
		args: args{
			n: 1,
		},
		want: []string{"()"},
	},
}
