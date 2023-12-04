package pathcrossing

type args struct {
	path string
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: path = \"NES\"",
		args: args{
			path: "NES",
		},
		want: false,
	},
	{
		name: "case: path = \"NESWW\"",
		args: args{
			path: "NESWW",
		},
		want: true,
	},
	{
		name: "case: path = \"ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS\"",
		args: args{
			path: "ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS",
		},
		want: false,
	},
}
