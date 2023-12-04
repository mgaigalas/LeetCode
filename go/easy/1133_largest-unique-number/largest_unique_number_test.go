package largestuniquenumber

import "testing"

func Test_largestUniqueNumber(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := largestUniqueNumber(tt.args.nums); got != tt.want {
				t.Errorf("largestUniqueNumber() = %v, want %v", got, tt.want)
			}
		})
	}
}
