package dividechocolate

import "testing"

func Test_maximizeSweetness(t *testing.T) {
	for _, tt := range testCases {
		t.Run(tt.name, func(t *testing.T) {
			if got := maximizeSweetness(tt.args.sweetness, tt.args.k); got != tt.want {
				t.Errorf("maximizeSweetness() = %v, want %v", got, tt.want)
			}
		})
	}
}
