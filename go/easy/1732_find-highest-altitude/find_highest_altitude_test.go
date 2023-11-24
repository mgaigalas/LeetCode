package findhighestalt

import "testing"

func Test_largestAltitude(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := largestAltitude(tt.args.nums); got != tt.want {
				t.Errorf("largestAltitude() = %v, want %v", got, tt.want)
			}
		})
	}
}
