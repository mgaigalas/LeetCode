package minvalforgetposstpbystpsum

import "testing"

func Test_minStartValue(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := minStartValue(tt.args.nums); got != tt.want {
				t.Errorf("minStartValue() = %v, want %v", got, tt.want)
			}
		})
	}
}
