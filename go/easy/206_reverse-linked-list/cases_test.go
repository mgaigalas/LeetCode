package reverselinkedlist

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
		want: []int{5, 4, 3, 2, 1},
	},
	{
		name: "case: head = [1,2]",
		args: args{
			head: []int{1, 2},
		},
		want: []int{2, 1},
	},
	{
		name: "case: head = []",
		args: args{
			head: []int{},
		},
		want: []int{},
	},
}
