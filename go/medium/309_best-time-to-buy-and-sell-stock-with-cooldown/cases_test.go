package besttimetobuyandsellstockwithcooldown

type args struct {
	prices []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: prices = [1,2,3,0,2]",
		args: args{
			prices: []int{1, 2, 3, 0, 2},
		},
		want: 3,
	},
	{
		name: "case: prices = [1]",
		args: args{
			prices: []int{1},
		},
		want: 0,
	},
}
