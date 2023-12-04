package sumofuniqueelements

import "testing"

func Test_sumOfUnique(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := sumOfUnique(tt.args.nums); got != tt.want {
				t.Errorf("sumOfUnique() = %v, want %v", got, tt.want)
			}
		})
	}
}
