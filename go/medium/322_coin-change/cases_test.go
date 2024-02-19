package coinchange

type args struct {
	coins  []int
	amount int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: coins = [1,2,5], amount = 11",
		args: args{
			coins:  []int{1, 2, 5},
			amount: 11,
		},
		want: 3,
	},
	{
		name: "case: coins = [2], amount = 3",
		args: args{
			coins:  []int{2},
			amount: 3,
		},
		want: -1,
	},
	{
		name: "case: coins = [1], amount = 0",
		args: args{
			coins:  []int{1},
			amount: 0,
		},
		want: 0,
	},
	{
		name: "case: coins = [1,2], amount = 3",
		args: args{
			coins:  []int{1, 2},
			amount: 3,
		},
		want: 2,
	},
	{
		name: "case: coins = [411,412,413,414,415,416,417,418,419,420,421,422], amount = 9864",
		args: args{
			coins:  []int{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422},
			amount: 9864,
		},
		want: 24,
	},
}
