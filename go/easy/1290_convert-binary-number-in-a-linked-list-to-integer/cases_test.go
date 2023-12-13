package convbinarynuminlinkedlsttoint

type args struct {
	head []int
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: head = [1,0,1]",
		args: args{
			head: []int{1, 0, 1},
		},
		want: 5,
	},
	{
		name: "case: head = [0]",
		args: args{
			head: []int{0},
		},
		want: 0,
	},
	{
		name: "case: head = [1]",
		args: args{
			head: []int{1},
		},
		want: 1,
	},
	{
		name: "case: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]",
		args: args{
			head: []int{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
		},
		want: 18880,
	},
}
