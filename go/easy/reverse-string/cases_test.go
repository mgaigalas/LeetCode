package revstr

type args struct {
	s []byte
}

var testCases = []struct {
	name string
	args args
	want []byte
}{
	{
		name: "case: ['h','e','l','l','o']",
		args: args{
			s: []byte{'h', 'e', 'l', 'l', 'o'},
		},
		want: []byte{'o', 'l', 'l', 'e', 'h'},
	},
	{
		name: "case: ['H','a','n','n','a','h']",
		args: args{
			s: []byte{'H', 'a', 'n', 'n', 'a', 'h'},
		},
		want: []byte{'h', 'a', 'n', 'n', 'a', 'H'},
	},
}
