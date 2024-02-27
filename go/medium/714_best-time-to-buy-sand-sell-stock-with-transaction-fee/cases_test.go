package besttimetobuysandsellstockwithtrfee

type args struct {
	prices []int
	fee    int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: prices = [1,3,2,8,4,9], fee = 2",
		args: args{
			prices: []int{1, 3, 2, 8, 4, 9},
			fee:    2,
		},
		want: 8,
	},
	{
		name: "case: prices = [1,3,7,5,10,3], fee = 3",
		args: args{
			prices: []int{1, 3, 7, 5, 10, 3},
			fee:    3,
		},
		want: 6,
	},
	{
		name: "case: prices = [9,8,7,1,2], fee = 3",
		args: args{
			prices: []int{9, 8, 7, 1, 2},
			fee:    3,
		},
		want: 0,
	},
}
