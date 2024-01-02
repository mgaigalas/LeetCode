package onlinestockspan

type args struct {
	vals []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [\"StockSpanner\", \"next\", \"next\", \"next\", \"next\", \"next\", \"next\", \"next\"]\n[[], [100], [80], [60], [70], [60], [75], [85]]",
		args: args{
			vals: []int{100, 80, 60, 70, 60, 75, 85},
		},
		want: []int{1, 1, 1, 2, 1, 4, 6},
	},
}
