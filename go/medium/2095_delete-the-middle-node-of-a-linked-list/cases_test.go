package deletemidnodeoflinkedlist

type args struct {
	head []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: head = [1,3,4,7,1,2,6]",
		args: args{
			head: []int{1, 3, 4, 7, 1, 2, 6},
		},
		want: []int{1, 3, 4, 1, 2, 6},
	},
	{
		name: "case: head = [1,2,3,4]",
		args: args{
			head: []int{1, 2, 3, 4},
		},
		want: []int{1, 2, 4},
	},
	{
		name: "case: head = [2,1]",
		args: args{
			head: []int{2, 1},
		},
		want: []int{2},
	},
	{
		name: "case: head = [1]",
		args: args{
			head: []int{1},
		},
		want: []int{},
	},
}
