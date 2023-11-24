package maxconseconesthree

import "testing"

func Test_longestOnes(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := longestOnes(tt.args.nums, tt.args.k); got != tt.want {
				t.Errorf("longestOnes() = %v, want %v", got, tt.want)
			}
		})
	}
}
