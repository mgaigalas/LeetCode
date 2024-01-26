package minimumcosttoconnectsticks

type args struct {
	sticks []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: sticks = [2,4,3]",
		args: args{
			sticks: []int{2, 4, 3},
		},
		want: 14,
	},
	{
		name: "case: sticks = [1,8,3,5]",
		args: args{
			sticks: []int{1, 8, 3, 5},
		},
		want: 30,
	},
	{
		name: "case: sticks = [5]",
		args: args{
			sticks: []int{5},
		},
		want: 0,
	},
}
