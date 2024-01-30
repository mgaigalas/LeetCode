package howmanyapplescanyouputintobasket

import "testing"

func Test_maxNumberOfApples(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxNumberOfApples(tt.args.weight); got != tt.want {
				t.Errorf("maxNumberOfApples() = %v, want %v", got, tt.want)
			}
		})
	}
}
