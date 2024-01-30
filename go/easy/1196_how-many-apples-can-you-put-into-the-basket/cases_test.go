package howmanyapplescanyouputintobasket

type args struct {
	weight []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: weight = [100,200,150,1000]",
		args: args{
			weight: []int{100, 200, 150, 1000},
		},
		want: 4,
	},
	{
		name: "case: weight = [900,950,800,1000,700,800]",
		args: args{
			weight: []int{900, 950, 800, 1000, 700, 800},
		},
		want: 5,
	},
}
