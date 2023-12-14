package removenthnodefromendoflist

type args struct {
	head []int
	n    int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: head = [1,2,3,4,5], n = 2",
		args: args{
			head: []int{1, 2, 3, 4, 5},
			n:    2,
		},
		want: []int{1, 2, 3, 5},
	},
	{
		name: "case: head = [1], n = 1",
		args: args{
			head: []int{1},
			n:    1,
		},
		want: []int{},
	},
	{
		name: "case: head = [1,2], n = 1",
		args: args{
			head: []int{1, 2},
			n:    1,
		},
		want: []int{1},
	},
}
