package openthelock

type args struct {
	deadends []string
	target   string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: deadends = [\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"], target = \"0202\"",
		args: args{
			deadends: []string{"0201", "0101", "0102", "1212", "2002"},
			target:   "0202",
		},
		want: 6,
	},
	{
		name: "case: deadends = [\"8888\"], target = \"0009\"",
		args: args{
			deadends: []string{"8888"},
			target:   "0009",
		},
		want: 1,
	},
	{
		name: "case: deadends = [\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"], " +
			"target = \"8888\"",
		args: args{
			deadends: []string{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"},
			target:   "8888",
		},
		want: -1,
	},
}
