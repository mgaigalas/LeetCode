package maxnumofballoons

type args struct {
	text string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: \"nlaebolko\"",
		args: args{
			text: "nlaebolko",
		},
		want: 1,
	},
	{
		name: "case: \"loonbalxballpoon\"",
		args: args{
			text: "loonbalxballpoon",
		},
		want: 2,
	},
	{
		name: "case: \"leetcode\"",
		args: args{
			text: "leetcode",
		},
		want: 0,
	},
	{
		name: "case: \"balon\"",
		args: args{
			text: "balon",
		},
		want: 0,
	},
	{
		name: "case: \"nlaebolko\"",
		args: args{
			text: "nlaebolko",
		},
		want: 1,
	},
	{
		name: "case: \"loonbalxballpoon\"",
		args: args{
			text: "loonbalxballpoon",
		},
		want: 2,
	},
	{
		name: "case: \"leetcode\"",
		args: args{
			text: "leetcode",
		},
		want: 0,
	},
	{
		name: "case: \"lloo\"",
		args: args{
			text: "lloo",
		},
		want: 0,
	},
}
