package customsortstring

import "testing"

func Test_customSortString(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			got := customSortString(tt.args.order, tt.args.s)
			for _, want := range tt.want {
				if got == want {
					return
				}
			}
			t.Errorf("customSortString() = %v, want %v", got, tt.want)
		})
	}
}
