package containsduplicate

type args struct {
	nums []int
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: [1,2,3,1]",
		args: args{
			nums: []int{1, 2, 3, 1},
		},
		want: true,
	},
	{
		name: "case: [1,2,3,4]",
		args: args{
			nums: []int{1, 2, 3, 4},
		},
		want: false,
	},
	{
		name: "case: [1,1,1,3,3,4,3,2,4,2]",
		args: args{
			nums: []int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2},
		},
		want: true,
	},
}
