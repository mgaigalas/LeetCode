package jumpgamethree

type args struct {
	arr   []int
	start int
}

var testCases = []struct {
	name string
	args args
	want bool
}{
	{
		name: "case: arr = [4,2,3,0,3,1,2], start = 5",
		args: args{
			arr:   []int{4, 2, 3, 0, 3, 1, 2},
			start: 5,
		},
		want: true,
	},
	{
		name: "case: arr = [4,2,3,0,3,1,2], start = 0",
		args: args{
			arr:   []int{4, 2, 3, 0, 3, 1, 2},
			start: 0,
		},
		want: true,
	},
	{
		name: "case: arr = [3,0,2,1,2], start = 2",
		args: args{
			arr:   []int{3, 0, 2, 1, 2},
			start: 2,
		},
		want: false,
	},
	{
		name: "case: arr = [1,1,1,1,1,1,1,1,0], start = 3",
		args: args{
			arr:   []int{1, 1, 1, 1, 1, 1, 1, 1, 0},
			start: 3,
		},
		want: true,
	},
	{
		name: "case: arr = [45,48,129,96,72,20,140,10,105,37,119,40,76,10,166,76,149,74,8,157,134,83,75,8,124,22,41," +
			"162,152,98,161,126,67,114,5,107,8,75,12,88,51,87,46,62,35,23,10,24,39,78,80,126,151,146,153,121,5,98,147," +
			"139,97,60,134,36,140,26,106,141,98,57,142,2,152,146,143,80,104,99,142,161,170,55,33,111,45,28,145,28,76," +
			"44,90,120,127,134,41,150,68,163,61,67,18,130,83,62,167,156,142,56,67,41,163,33,14,118,91,33,158,63,77,10," +
			"108,114,126,13,44,143,96,170,127,167,80,78,71,40,91,170,135,94,23,109,62,93,24,90,62,16,93,136,169,168," +
			"79,11,145,90,132,3,98,168,24,0,0,146,45,118,27,55,95,17,131,35,102,47], start = 112",
		args: args{
			arr: []int{45, 48, 129, 96, 72, 20, 140, 10, 105, 37, 119, 40, 76, 10, 166, 76, 149, 74, 8, 157, 134,
				83, 75, 8, 124, 22, 41, 162, 152, 98, 161, 126, 67, 114, 5, 107, 8, 75, 12, 88, 51, 87, 46, 62, 35,
				23, 10, 24, 39, 78, 80, 126, 151, 146, 153, 121, 5, 98, 147, 139, 97, 60, 134, 36, 140, 26, 106, 141,
				98, 57, 142, 2, 152, 146, 143, 80, 104, 99, 142, 161, 170, 55, 33, 111, 45, 28, 145, 28, 76, 44, 90,
				120, 127, 134, 41, 150, 68, 163, 61, 67, 18, 130, 83, 62, 167, 156, 142, 56, 67, 41, 163, 33, 14, 118,
				91, 33, 158, 63, 77, 10, 108, 114, 126, 13, 44, 143, 96, 170, 127, 167, 80, 78, 71, 40, 91, 170, 135,
				94, 23, 109, 62, 93, 24, 90, 62, 16, 93, 136, 169, 168, 79, 11, 145, 90, 132, 3, 98, 168, 24, 0, 0,
				146, 45, 118, 27, 55, 95, 17, 131, 35, 102, 47},
			start: 112,
		},
		want: true,
	},
}
