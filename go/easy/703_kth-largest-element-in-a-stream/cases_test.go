package kthlargestelementinstream

type constructorArgs struct {
	nums []int
	k    int
}

type args struct {
	constrArgs constructorArgs
	nums       []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: [\"KthLargest\", \"add\", \"add\", \"add\", \"add\", \"add\"]" +
			"\n[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]",
		args: args{
			constrArgs: constructorArgs{
				nums: []int{4, 5, 8, 2},
				k:    3,
			},
			nums: []int{3, 5, 10, 9, 4},
		},
		want: []int{4, 5, 5, 8, 8},
	},
	{
		name: "case: [\"KthLargest\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\"," +
			"\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\",\"add\"," +
			"\"add\",\"add\",\"add\",\"add\"]" +
			"\n[[7,[-10,1,3,1,4,10,3,9,4,5,1]],[3],[2],[3],[1],[2],[4],[5],[5],[6],[7],[7],[8],[2],[3],[1],[1],[1]," +
			"[10],[11],[5],[6],[2],[4],[7],[8],[5],[6]]",
		args: args{
			constrArgs: constructorArgs{
				nums: []int{-10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1},
				k:    7,
			},
			nums: []int{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6},
		},
		want: []int{3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7},
	},
}
