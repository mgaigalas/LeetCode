package reverselinkedlisttwo

type args struct {
	head  []int
	left  int
	right int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: head = [1,2,3,4,5], left = 2, right = 4",
		args: args{
			head:  []int{1, 2, 3, 4, 5},
			left:  2,
			right: 4,
		},
		want: []int{1, 4, 3, 2, 5},
	},
	{
		name: "case: head = [5], left = 1, right = 1",
		args: args{
			head:  []int{5},
			left:  1,
			right: 1,
		},
		want: []int{5},
	},
}
