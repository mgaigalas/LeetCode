package besttimetobuyandsellstocktwo

type args struct {
	prices []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "prices = [7,1,5,3,6,4]",
		args: args{
			prices: []int{7, 1, 5, 3, 6, 4},
		},
		want: 7,
	},
	{
		name: "prices = [1,2,3,4,5]",
		args: args{
			prices: []int{1, 2, 3, 4, 5},
		},
		want: 4,
	},
	{
		name: "prices = [7,6,4,3,1]",
		args: args{
			prices: []int{7, 6, 4, 3, 1},
		},
		want: 0,
	},
}
