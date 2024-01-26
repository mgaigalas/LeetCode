package minimumcosttoconnectsticks

import "testing"

func Test_connectSticks(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := connectSticks(tt.args.sticks); got != tt.want {
				t.Errorf("connectSticks() = %v, want %v", got, tt.want)
			}
		})
	}
}
