package maxnumofballoons

import "testing"

func Test_maxNumberOfBalloons(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxNumberOfBalloons(tt.args.text); got != tt.want {
				t.Errorf("maxNumberOfBalloons() = %v, want %v", got, tt.want)
			}
		})
	}
}
