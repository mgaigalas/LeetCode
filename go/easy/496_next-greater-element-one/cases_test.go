package nextgreaterelementone

type args struct {
	nums1, nums2 []int
}

var testCases = []struct {
	name string
	args args
	want []int
}{
	{
		name: "case: nums1 = [4,1,2], nums2 = [1,3,4,2]",
		args: args{
			nums1: []int{4, 1, 2},
			nums2: []int{1, 3, 4, 2},
		},
		want: []int{-1, 3, -1},
	},
	{
		name: "case: nums1 = [2,4], nums2 = [1,2,3,4]",
		args: args{
			nums1: []int{2, 4},
			nums2: []int{1, 2, 3, 4},
		},
		want: []int{3, -1},
	},
	{
		name: "case: nums1 = [1,3,5,2,4], nums2 = [6,5,4,3,2,1,7]",
		args: args{
			nums1: []int{1, 3, 5, 2, 4},
			nums2: []int{6, 5, 4, 3, 2, 1, 7},
		},
		want: []int{7, 7, 7, 7, 7},
	},
}
