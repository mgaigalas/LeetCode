package equalsubstrswithinbudget

type args struct {
	s       string
	t       string
	maxCost int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: s = \"abcd\", t = \"bcdf\", maxCost = 3",
		args: args{
			s:       "abcd",
			t:       "bcdf",
			maxCost: 3,
		},
		want: 3,
	},
	{
		name: "case: s = \"abcd\", t = \"cdef\", maxCost = 3",
		args: args{
			s:       "abcd",
			t:       "cdef",
			maxCost: 3,
		},
		want: 1,
	},
	{
		name: "case: s = \"abcd\", t = \"acde\", maxCost = 0",
		args: args{
			s:       "abcd",
			t:       "acde",
			maxCost: 0,
		},
		want: 1,
	},
}
