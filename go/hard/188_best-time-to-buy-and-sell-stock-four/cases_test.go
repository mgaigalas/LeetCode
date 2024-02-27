package besttimetobuyandsellstockfour

type args struct {
	k      int
	prices []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "k = 2, prices = [2,4,1]",
		args: args{
			k:      2,
			prices: []int{2, 4, 1},
		},
		want: 2,
	},
	{
		name: "k = 2, prices = [3,2,6,5,0,3]",
		args: args{
			k:      2,
			prices: []int{3, 2, 6, 5, 0, 3},
		},
		want: 7,
	},
}
