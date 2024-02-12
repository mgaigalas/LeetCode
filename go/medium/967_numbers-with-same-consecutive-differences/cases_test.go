package numswithsameconsecdiffs

type args struct {
	n int
	k int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: n = 3, k = 7",
		args: args{
			n: 3,
			k: 7,
		},
		want: []int{181, 292, 707, 818, 929},
	},
	{
		name: "case: n = 2, k = 1",
		args: args{
			n: 2,
			k: 1,
		},
		want: []int{10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98},
	},
}
