package reducearraysizetohalf

type args struct {
	arr []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: arr = [3,3,3,3,5,5,5,2,2,7]",
		args: args{
			arr: []int{3, 3, 3, 3, 5, 5, 5, 2, 2, 7},
		},
		want: 2,
	},
	{
		name: "case: arr = [7,7,7,7,7,7]",
		args: args{
			arr: []int{7, 7, 7, 7, 7, 7},
		},
		want: 1,
	},
	{
		name: "case: arr = [1,2,3,4,5,6,7,8,9,10]",
		args: args{
			arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
		},
		want: 5,
	},
}
