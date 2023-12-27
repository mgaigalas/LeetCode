package simplifypath

type args struct {
	path string
}

var testCases = []struct {
	name string
	args args
	want string
}{
	{
		name: "case: path = \"/home/\"",
		args: args{
			path: "/home/",
		},
		want: "/home",
	},
	{
		name: "case: path = \"/../\"",
		args: args{
			path: "/../",
		},
		want: "/",
	},
	{
		name: "case: path = \"/home//foo/\"",
		args: args{
			path: "/home//foo/",
		},
		want: "/home/foo",
	},
	{
		name: "case: path = \"/a/./b/../../c/\"",
		args: args{
			path: "/a/./b/../../c/",
		},
		want: "/c",
	},
}
