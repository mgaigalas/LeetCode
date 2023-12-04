package pathcrossing

import "testing"

func Test_isPathCrossing(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := isPathCrossing(tt.args.path); got != tt.want {
				t.Errorf("isPathCrossing() = %v, want %v", got, tt.want)
			}
		})
	}
}
