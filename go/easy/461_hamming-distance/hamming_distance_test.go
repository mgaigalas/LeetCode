package hammingdistance

import "testing"

func Test_hammingDistance(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := hammingDistance(tt.args.x, tt.args.y); got != tt.want {
				t.Errorf("hammingDistance() = %v, want %v", got, tt.want)
			}
		})
	}
}
