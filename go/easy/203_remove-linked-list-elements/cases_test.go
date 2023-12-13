package rmlinkedlistelements

type args struct {
	head []int
	val  int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: head = [1,2,6,3,4,5,6], val = 6",
		args: args{
			head: []int{1, 2, 6, 3, 4, 5, 6},
			val:  6,
		},
		want: []int{1, 2, 3, 4, 5},
	},
	{
		name: "case: head = [], val = 1",
		args: args{
			head: []int{},
			val:  1,
		},
		want: []int{},
	},
	{
		name: "case: head = [7,7,7,7], val = 7",
		args: args{
			head: []int{7, 7, 7, 7},
			val:  7,
		},
		want: []int{},
	},
}
