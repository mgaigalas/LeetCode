package minsizesubarraysum

import "testing"

func Test_minSubArrayLen(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := minSubArrayLen(tt.args.target, tt.args.nums); got != tt.want {
				t.Errorf("minSubArrayLen() = %v, want %v", got, tt.want)
			}
		})
	}
}
