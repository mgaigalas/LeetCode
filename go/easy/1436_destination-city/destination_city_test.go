package destinationcity

import "testing"

func Test_destCity(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := destCity(tt.args.paths); got != tt.want {
				t.Errorf("destCity() = %v, want %v", got, tt.want)
			}
		})
	}
}
