package middleoflinkedlist

type args struct {
	head []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [1,2,3,4,5]",
		args: args{
			head: []int{1, 2, 3, 4, 5},
		},
		want: []int{3, 4, 5},
	},
	{
		name: "case: [1,2,3,4,5,6]",
		args: args{
			head: []int{1, 2, 3, 4, 5, 6},
		},
		want: []int{4, 5, 6},
	},
}
