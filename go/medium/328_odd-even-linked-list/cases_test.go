package oddevenlinkedlist

type args struct {
	head []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: head = [1,2,3,4,5]",
		args: args{
			head: []int{1, 2, 3, 4, 5},
		},
		want: []int{1, 3, 5, 2, 4},
	},
	//{
	//	name: "case: head = [2,1,3,5,6,4,7]",
	//	args: args{
	//		head: []int{2, 1, 3, 5, 6, 4, 7},
	//	},
	//	want: []int{2, 3, 6, 7, 1, 5, 4},
	//},
}
