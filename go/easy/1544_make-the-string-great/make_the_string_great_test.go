package makethestringgreat

import "testing"

func Test_makeGood(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := makeGood(tt.args.s); got != tt.want {
				t.Errorf("makeGood() = %v, want %v", got, tt.want)
			}
		})
	}
}
