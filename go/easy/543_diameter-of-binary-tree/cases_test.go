package diameterofbinarytree

type args struct {
	root []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: root = [1,2,3,4,5]",
		args: args{
			root: []int{1, 2, 3, 4, 5},
		},
		want: 3,
	},
	{
		name: "case: root = [1,2]",
		args: args{
			root: []int{1, 2},
		},
		want: 1,
	},
}
