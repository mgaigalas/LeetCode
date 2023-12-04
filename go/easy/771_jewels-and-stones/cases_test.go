package jewelsandstones

type args struct {
	jewels string
	stones string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: jewels = \"aA\", stones = \"aAAbbbb\"",
		args: args{
			jewels: "aA",
			stones: "aAAbbbb",
		},
		want: 3,
	},
	{
		name: "case: jewels = \"z\", stones = \"ZZ\"",
		args: args{
			jewels: "z",
			stones: "ZZ",
		},
		want: 0,
	},
}
