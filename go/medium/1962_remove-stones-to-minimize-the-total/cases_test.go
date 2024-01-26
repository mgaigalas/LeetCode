package removestonestominimizetotal

type args struct {
	piles []int
	k     int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: piles = [5,4,9], k = 2",
		args: args{
			piles: []int{5, 4, 9},
			k:     2,
		},
		want: 12,
	},
	{
		name: "case: piles = [4,3,6,7], k = 3",
		args: args{
			piles: []int{4, 3, 6, 7},
			k:     3,
		},
		want: 12,
	},
}
