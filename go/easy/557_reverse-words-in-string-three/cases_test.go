package revwordsinstrthree

type args struct {
	s string
}

var testCases = []struct {
	name string
	args args
	want string
}{
	{
		name: "case: \"Let's take LeetCode contest\"",
		args: args{
			s: "Let's take LeetCode contest",
		},
		want: "s'teL ekat edoCteeL tsetnoc",
	},
	{
		name: "case: \"God Ding\"",
		args: args{
			s: "God Ding",
		},
		want: "doG gniD",
	},
}
