package palindromelinkedlist

type args struct {
	head []int
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: head = [1,2,2,1]",
		args: args{
			head: []int{1, 2, 2, 1},
		},
		want: true,
	},
	{
		name: "case: head = [1,2]",
		args: args{
			head: []int{1, 2},
		},
		want: false,
	},
}
