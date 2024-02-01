package kokoeatingbananas

type args struct {
	piles []int
	h     int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: piles = [3,6,7,11], h = 8",
		args: args{
			piles: []int{3, 6, 7, 11},
			h:     8,
		},
		want: 4,
	},
	{
		name: "case: piles = [30,11,23,4,20], h = 5",
		args: args{
			piles: []int{30, 11, 23, 4, 20},
			h:     5,
		},
		want: 30,
	},
	{
		name: "case: piles = [30,11,23,4,20], h = 6",
		args: args{
			piles: []int{30, 11, 23, 4, 20},
			h:     6,
		},
		want: 23,
	},
}
