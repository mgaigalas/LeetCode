package movingavgfromdatastream

type args struct {
	vals []int
}

var testCases = []struct {
	name string
	args args
	want []float64
}{
	{
		name: "case: [\"MovingAverage\", \"next\", \"next\", \"next\", \"next\"]\n[[3], [1], [10], [3], [5]]",
		args: args{
			vals: []int{3, 1, 10, 3, 5},
		},
		want: []float64{1.0, 5.5, 4.66667, 6.0},
	},
}
