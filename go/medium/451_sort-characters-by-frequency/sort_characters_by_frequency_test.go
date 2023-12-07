package sortcharsbyfreq

import "testing"

func Test_frequencySort(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			got := frequencySort(tt.args.s)
			for _, want := range tt.want {
				if got == want {
					return
				}
			}
			t.Errorf("frequencySort() = %v, want %v", got, tt.want)
		})
	}
}
